/*
 * (c) Midland Software Limited 2025
 * Name     : ReadyState.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.State;

public class ReadyState extends State {

    public ReadyState(final PullRequest pullRequest) {
    }

    @Override
    public void approve(PullRequest pullRequest) {
        System.out.println(pullRequest + " is approved");
        pullRequest.setState(new ApprovedState(pullRequest));
    }

    @Override
    public void close(PullRequest pullRequest) {
        System.out.println(pullRequest + " is closed");
        pullRequest.setState(new ClosedState(pullRequest));
    }
}
