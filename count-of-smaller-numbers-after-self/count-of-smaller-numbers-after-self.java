                    root.left = new TreeNode(val); break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if(root.right == null) {
                    root.right = new TreeNode(val); break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }
}
​
class TreeNode {
    TreeNode left; 
    TreeNode right;
    int val;
    int count = 1;
    public TreeNode(int val) {
        this.val = val;
    }
}
