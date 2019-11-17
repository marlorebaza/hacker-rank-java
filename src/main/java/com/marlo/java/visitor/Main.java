package com.marlo.java.visitor;

import java.util.*;

public class Main {

    static class RawNode {
        int value;
        Color color;
        List<Integer> relatedIndexes = new ArrayList<>();
        boolean visited;
    }

    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        RawNode[] rawNodes = new RawNode[length];
        for (int i = 0; i < length; i++) {
            rawNodes[i] = new RawNode();
            rawNodes[i].value = scan.nextInt();
        }
        for (int i = 0; i < length; i++) {
            rawNodes[i].color = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        for (int i = 0; i < length - 1; i++) {
            int left = scan.nextInt() - 1;
            int right = scan.nextInt() - 1;
            rawNodes[left].relatedIndexes.add(right);
            rawNodes[right].relatedIndexes.add(left);
        }
        scan.close();
        return map(rawNodes[0], rawNodes, 0);
    }

    private static Tree map(RawNode rawNode, RawNode[] rawNodes, int depth) {
        rawNode.visited = true;
        List<Tree> children = new ArrayList();
        for (Integer relatedIndex : rawNode.relatedIndexes) {
            if (!rawNodes[relatedIndex].visited) {
                children.add(map(rawNodes[relatedIndex], rawNodes, depth + 1));
            }
        }
        if (children.isEmpty()) {
            return new TreeLeaf(rawNode.value, rawNode.color, depth);
        } else {
            TreeNode treeNode = new TreeNode(rawNode.value, rawNode.color, depth);
            for (Tree child : children) {
                treeNode.addChild(child);
            }
            return treeNode;
        }
    }


/*

    // PRIMERA SOLUCION

    private static List<Tree> map(List<Integer> indexes, int depth, int[][] nodes, List<int[]> edges) {
        Map<Integer, List<Integer>> childrenIndex = new HashMap();
        for (Iterator<int[]> edgeIterator = edges.iterator(); edgeIterator.hasNext();) {
            int[] edge = edgeIterator.next();
            int edgeLeftIndex = edge[0] - 1;
            int edgeRightIndex = edge[1] - 1;
            for (Integer index : indexes) {
                if (edgeLeftIndex == index) {
                    edgeIterator.remove();
                    addToMap(index, edgeRightIndex, childrenIndex);
                } else if (edgeRightIndex == index) {
                    edgeIterator.remove();
                    addToMap(index, edgeLeftIndex, childrenIndex);
                }
            }
        }
        List<Tree> root = new ArrayList();
        for (Integer i : indexes) {
            List<Tree> children = new ArrayList();
            if (childrenIndex.get(i) != null) {
                children = map(childrenIndex.get(i), depth + 1, nodes, edges);
            }
            if (children.isEmpty()) {
                root.add(new TreeLeaf(nodes[i][0], nodes[i][1] == 0 ? Color.RED : Color.GREEN, depth));
            } else {
                TreeNode treeNode = new TreeNode(nodes[i][0], nodes[i][1] == 0 ? Color.RED : Color.GREEN, depth);
                for (Tree child : children) {
                    treeNode.addChild(child);
                }
                root.add(treeNode);
            }
        }
        return root;
    }
    */

/*
*   // SEGUNDA SOLUCION
*
*   class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private java.math.BigInteger result = BigInteger.valueOf(1);

    public int getResult() {
        return result.remainder(java.math.BigInteger.valueOf(1000000007)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (Color.RED == node.getColor()) {
            result = result.multiply(java.math.BigInteger.valueOf(node.getValue()));
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.RED == leaf.getColor()) {
            result = result.multiply(java.math.BigInteger.valueOf(leaf.getValue()));
        }
    }
}

class FancyVisitor extends TreeVis {
    private int resultNode = 0;
    private int resultLeaf = 0;

    public int getResult() {
        return Math.abs(resultNode - resultLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            resultNode += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.GREEN == leaf.getColor()) {
            resultLeaf += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {

        Scanner scan = new Scanner(System.in);

        int l = scan.nextInt();

        int[][] n = new int[l][2];

        for (int i = 0; i < l; i++) {
            n[i][0] = scan.nextInt();
        }

        for (int i = 0; i < l; i++) {
            n[i][1] = scan.nextInt();
        }

        List<int[]> e = new ArrayList();
        for (int i = 0; i < (l-1); i++) {
            e.add(new int[]{scan.nextInt(), scan.nextInt()});
        }
        scan.close();

        return (Tree) map(new ArrayList(){{add(0);}}, 0, n, e).get(0);
    }

    private static void addToMap(int key, int value, Map<Integer, List<Integer>> map) {
        List<Integer> values = map.get(key);
        if (values == null) {
            List<Integer> l = new ArrayList();
            l.add(value);
            map.put(key, l);
        } else {
            values.add(value);
        }
    }

    private static List<Tree> map(List<Integer> indexes, int depth, int[][] nodes, List<int[]> edges) {
        Map<Integer, List<Integer>> childrenIndex = new HashMap();
        for (Iterator<int[]> edgeIterator = edges.iterator(); edgeIterator.hasNext();) {
            int[] edge = edgeIterator.next();
            int edgeLeftIndex = edge[0] - 1;
            int edgeRightIndex = edge[1] - 1;
            for (Integer index : indexes) {
                if (edgeLeftIndex == index) {
                    edgeIterator.remove();
                    addToMap(index, edgeRightIndex, childrenIndex);
                } else if (edgeRightIndex == index) {
                    edgeIterator.remove();
                    addToMap(index, edgeLeftIndex, childrenIndex);
                }
            }
        }
        List<Tree> root = new ArrayList();
        for (Integer i : indexes) {
            List<Tree> children = new ArrayList();
            if (childrenIndex.get(i) != null) {
                children = map(childrenIndex.get(i), depth + 1, nodes, edges);
            }
            if (children.isEmpty()) {
                root.add(new TreeLeaf(nodes[i][0], nodes[i][1] == 0 ? Color.RED : Color.GREEN, depth));
            } else {
                TreeNode treeNode = new TreeNode(nodes[i][0], nodes[i][1] == 0 ? Color.RED : Color.GREEN, depth);
                for (Tree child : children) {
                    treeNode.addChild(child);
                }
                root.add(treeNode);
            }
        }
        return root;
    }
*
* */

    public static void main(String[] args) {
        System.out.print(new Date());
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.print(new Date());
    }

    /*
    * SOLUCION 1:
    *

    public static Tree solve() {

        Scanner scan = new Scanner(System.in);

        int l = scan.nextInt();

        int[][] n = new int[l][2];

        for (int i = 0; i < l; i++) {
            n[i][0] = scan.nextInt();
        }

        for (int i = 0; i < l; i++) {
            n[i][1] = scan.nextInt();
        }

        List<int[]> e = new ArrayList();
        for (int i = 0; i < (l-1); i++) {
            e.add(new int[]{scan.nextInt(), scan.nextInt()});
        }
        scan.close();

        return map(0, 0, n, e);
    }

    private static Tree map(int index, int depth, int[][] nodes, List<int[]> edges) {
        List<Tree> children = new ArrayList();
        List<Integer> childrenIndex = new ArrayList();
        for (Iterator<int[]> edgeIterator = edges.iterator(); edgeIterator.hasNext();) {
            int[] edge = edgeIterator.next();
            if (index == edge[0] - 1) {
                edgeIterator.remove();
                childrenIndex.add(edge[1] - 1);
            } else if (index == edge[1] - 1) {
                edgeIterator.remove();
                childrenIndex.add(edge[0] - 1);
            }
        }
        for (int nodeEdge : childrenIndex) {
            children.add(map(nodeEdge, depth + 1, nodes, edges));
        }
        if (children.isEmpty()) {
            return new TreeLeaf(nodes[index][0], nodes[index][1] == 0 ? Color.RED : Color.GREEN, depth);
        } else {
            TreeNode treeNode = new TreeNode(nodes[index][0], nodes[index][1] == 0 ? Color.RED : Color.GREEN, depth);
            for (Tree child : children) {
                treeNode.addChild(child);
            }
            return treeNode;
        }
    }
    *
    * */

}
