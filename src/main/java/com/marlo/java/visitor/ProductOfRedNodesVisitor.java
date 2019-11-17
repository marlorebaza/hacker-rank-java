package com.marlo.java.visitor;

import java.math.BigInteger;

public class ProductOfRedNodesVisitor  extends TreeVis {

    private BigInteger result = BigInteger.valueOf(1);

    public int getResult() {
        return result.remainder(BigInteger.valueOf(1000000007)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (Color.RED == node.getColor()) {
            this.result = this.result.multiply(BigInteger.valueOf(node.getValue()));
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.RED == leaf.getColor()) {
            this.result = this.result.multiply(BigInteger.valueOf(leaf.getValue()));
        }
    }
}
