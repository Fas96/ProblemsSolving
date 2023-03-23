package leetcode.Y2023.daily.dmedium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1472DesignBrowserHistory {

    Deque<String> forwardStack;
    Deque<String> backStack;
    String currentUrl;

    public Q1472DesignBrowserHistory(String homepage) {
        forwardStack = new ArrayDeque<>();
        backStack = new ArrayDeque<>();
        currentUrl = homepage;
    }

    public void visit(String url) {
        backStack.push(currentUrl);
        currentUrl = url;
        forwardStack.clear();
    }

    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(currentUrl);
            currentUrl = backStack.pop();
            steps--;
        }
        return currentUrl;
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(currentUrl);
            currentUrl = forwardStack.pop();
            steps--;
        }
        return currentUrl;
    }



}
