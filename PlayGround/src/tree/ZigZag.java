package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ZigZag {

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);

        boolean leftToRight = true;

        while (!Q.isEmpty()) {
            int levelsize = Q.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelsize; i++) {
                Node curr = Q.poll();


                if (leftToRight) {
                    currLevel.add(curr.val);
                } else {
                    currLevel.add(0, curr.val);
                }

                if (curr.left != null) Q.add(curr.left);
                if (curr.right != null) Q.add(curr.right);
            }
            leftToRight = !leftToRight;
            result.add(currLevel);
        }

        return result;
    }
}


