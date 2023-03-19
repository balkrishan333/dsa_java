package leetcode;

import java.util.*;

public class _1472_DesignBrowserHistory {

    private final Deque<String> back;
    private final Deque<String> forward;

    private String current;

    public static void main(String[] args) {
        String url = "leetcode";
        _1472_DesignBrowserHistory obj = new _1472_DesignBrowserHistory(url);
        obj.visit("google");
        obj.visit("facebook");
        obj.visit("youtube");
        System.out.println(obj.back(1));
        System.out.println(obj.back(1));
        System.out.println(obj.forward(1));
        obj.visit("linkedin");
        System.out.println(obj.forward(2));
        System.out.println(obj.back(2));
        System.out.println(obj.back(7));
    }

    /*
        Approach: Take 2 stacks, one for forward and one for backward traverse.
        When moving back, take out steps url from backward stack and push into forward
        When moving forward, take out steps url from forward stack and push into backward
     */
    public _1472_DesignBrowserHistory(String homepage) {
        back = new ArrayDeque<>();
        forward = new ArrayDeque<>();
        current = homepage;
    }

    public void visit(String url) {
        back.push(current);
        current = url;
        forward.clear(); //clear the forward as this is the current url and nothing to move beyond this
    }

    public String back(int steps) {
        while (steps-- > 0 && !back.isEmpty()) {
            forward.push(current);
            current = back.pop();
        }
        return current;
    }

    public String forward(int steps) {
        while (steps-- > 0 && !forward.isEmpty()) {
            back.push(current);
            current = forward.pop();
        }
        return current;
    }
}
