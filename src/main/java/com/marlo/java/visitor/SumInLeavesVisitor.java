package com.marlo.java.visitor;

public class SumInLeavesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
        return this.result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        this.result += leaf.getValue();
    }
}
