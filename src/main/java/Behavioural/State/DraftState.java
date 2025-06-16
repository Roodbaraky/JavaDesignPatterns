/*
 * (c) Midland Software Limited 2025
 * Name     : DraftState.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.State;

public class DraftState extends State {

    public DraftState(final PullRequest pullRequest) {
    }

    @Override
    public void markReady(PullRequest pullRequest) {
        System.out.println(pullRequest + " marked ready");
        pullRequest.setState(new ReadyState(pullRequest));
    }

    @Override
    public void close(PullRequest pullRequest) {
        System.out.println(pullRequest + " closed");
        pullRequest.setState(new ClosedState(pullRequest));
    }

}
