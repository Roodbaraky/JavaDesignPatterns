/*
 * (c) Midland Software Limited 2025
 * Name     : ApprovedState.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.State;

public class ApprovedState extends State {

    public ApprovedState(final PullRequest pullRequest) {
    }

    @Override
    public void merge(PullRequest pullRequest) {
        System.out.println(pullRequest + "Merged");
        pullRequest.setState(new MergedState(pullRequest));
    }

    @Override
    public void close(PullRequest pullRequest) {
        System.out.println(pullRequest + "Closed");
        pullRequest.setState(new ClosedState(pullRequest));
    }
}
