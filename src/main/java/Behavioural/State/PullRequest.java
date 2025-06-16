/*
 * (c) Midland Software Limited 2025
 * Name     : PullRequest.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.State;

public class PullRequest {

    private State state;
    private final String title;

    public PullRequest(String title) {
        state = new DraftState(this);
        this.title = title;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void markReady() {
        state.markReady(this);
    }

    public void approve() {
        state.approve(this);
    }

    public void merge() {
        state.merge(this);
    }

    public void close() {
        state.close(this);
    }

    @Override
    public String toString() {
        return title;
    }
}
