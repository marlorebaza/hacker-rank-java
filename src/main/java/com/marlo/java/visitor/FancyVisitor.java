package com.marlo.java.visitor;

public class FancyVisitor extends TreeVis {

    private int resultNode = 0;
    private int resultLeaf = 0;

    public int getResult() {
        return Math.abs(this.resultNode - this.resultLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            this.resultNode += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.GREEN == leaf.getColor()) {
            this.resultLeaf += leaf.getValue();
        }
    }
}
