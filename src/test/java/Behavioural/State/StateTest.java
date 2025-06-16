package Behavioural.State;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StateTest {

    private PullRequest pr;

    @BeforeEach
    void setUp() {
        pr = new PullRequest("#1234: Test Pull Request");
    }

    @Nested
    @DisplayName("When PR is in Draft state")
    class DraftStateTests {

        @Test
        void initialStateIsDraft() {
            assertInstanceOf(DraftState.class, pr.getState());
        }

        @Test
        void markReady_transitionsToReady() {
            pr.markReady();
            assertInstanceOf(ReadyState.class, pr.getState());
        }

        @Test
        void close_transitionsToClosed() {
            pr.close();
            assertInstanceOf(ClosedState.class, pr.getState());
        }

        @Test
        void approve_doesNotChangeState() {
            pr.approve();
            assertInstanceOf(DraftState.class, pr.getState());
        }

        @Test
        void merge_doesNotChangeState() {
            pr.merge();
            assertInstanceOf(DraftState.class, pr.getState());
        }
    }

    @Nested
    @DisplayName("When PR is in Ready state")
    class ReadyStateTests {
        @BeforeEach
        void setUp() {
            pr.setState(new ReadyState(pr));
        }

        @Test
        void approve_transitionsToApproved() {
            pr.approve();
            assertInstanceOf(ApprovedState.class, pr.getState());
        }

        @Test
        void close_transitionsToClosed() {
            pr.close();
            assertInstanceOf(ClosedState.class, pr.getState());
        }

        @Test
        void merge_doesNotChangeState() {
            pr.merge();
            assertInstanceOf(ReadyState.class, pr.getState());
        }

    }

    @Nested
    @DisplayName("When PR is in Approved state")
    class ApprovedStateTests {
        @BeforeEach
        void setUp() {
            pr.setState(new ApprovedState(pr));
        }

        @Test
        void approve_NoChange() {
            State state = pr.getState();
            pr.approve();
            assertSame(state, pr.getState());
        }

        @Test
        void close_transitionsToClosed() {
            pr.close();
            assertInstanceOf(ClosedState.class, pr.getState());
        }

        @Test
        void merge_transitionsToMerged() {
            pr.merge();
            assertInstanceOf(MergedState.class, pr.getState());
        }

    }

    @Nested
    @DisplayName("When PR is in Merged state")
    class MergedStateTests {
        @BeforeEach
        void setUp() {
            pr.setState(new MergedState(pr));
        }

        @Test
        void noEffectOnMerged() {
            State state = pr.getState();
            pr.markReady();
            pr.merge();
            pr.approve();
            pr.close();
            assertSame(state, pr.getState());
        }

    }

    @Nested
    @DisplayName("When PR is in Closed state")
    class ClosedStateTests {
        @BeforeEach
        void setUp() {
            pr.setState(new ClosedState(pr));
        }

        @Test
        void noEffectOnClosed() {
            State state = pr.getState();
            pr.markReady();
            pr.close();
            pr.approve();
            pr.merge();
            assertSame(state, pr.getState());
        }

    }

}