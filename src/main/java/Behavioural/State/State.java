/*
 * (c) Midland Software Limited 2025
 * Name     : State.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.State;

public abstract class State {

    public void markReady(final PullRequest pullRequest) {
        deny("mark ready");
    }

    public void approve(final PullRequest pullRequest) {
        deny("approve");
    }

    public void merge(final PullRequest pullRequest) {
        deny("merge");
    }

    public void close(final PullRequest pullRequest) {
       deny("close");
    }
    protected void deny(String action) {
        System.out.println("❌ Action '" + action + "' not allowed in state: " + this.getClass().getSimpleName());
    }
}
