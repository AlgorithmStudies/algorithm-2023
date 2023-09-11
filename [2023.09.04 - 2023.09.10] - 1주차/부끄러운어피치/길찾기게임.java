import java.util.*;

class 길찾기게임 {

    int[][] result;
    int idx;

    public int[][] solution(int[][] nodeinfo) {
        //노드를 입력받는다.
        Node[] node = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }
        //y값 큰 순서대로, y값 같다면 x값 작은 순서대로 정렬,
// 같은 레벨이면 같은 y좌표기때문에 y먼저 정렬, 그다음x순
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.y == n2.y) return n1.x - n2.x;
                else return n2.y - n1.y;
            }
        });

        //트리를 만든다.
        Node root = node[0];
        for(int i = 1; i < node.length; i++) {
            insertNode(root, node[i]);
        }

        result = new int[2][nodeinfo.length];
        idx = 0;
        preorder(root); //전위 순회
        idx = 0;
        postorder(root); //후위 순회
        return result;
    }
//문제에 있는대로 부모노드와 자식 노드 초기화시키는 메서드
//임의의 노드 V의 왼쪽 서브 트리(left subtree)에 있는 모든 노드의 x값은 V의 x값보다 작다.
//임의의 노드 V의 오른쪽 서브 트리(right subtree)에 있는 모든 노드의 x값은 V의 x값보다 크다. 
//문제를 충족하는 이진트리(최대 두 개의 자식 노드) 초기화
    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }


    //전위순회
    public void preorder(Node root) {
        if(root != null) {
            result[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    //후위순회
    public void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.value;
        }
    }
//노드 구조체 왼쪽 오른쪽 루트가 존재
    public class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
