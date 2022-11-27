import java.util.*;

public class DepthFirstSearch {
    public static Stack<Node> nodeStack = new Stack<>();
    public static Set<String> nodesVisited = new HashSet<>();
    public static ArrayList<Integer> jugCapacities = new ArrayList<Integer>(3);

    public static int doDepthFirstSearch(){
        int nodeCount = 0;

        Node rootNode = new Node(0,0,0);
        nodeStack.push(rootNode);
        nodesVisited.add(rootNode.toString());

        while(!nodeStack.isEmpty()){
            nodeCount++;

            Node node = nodeStack.pop();
            int jugA = node.getJugA();
            int jugB = node.getJugB();
            int jugC = node.getJugC();

            CommandLineApplication.outputNode(node);

            //Pour Jug A into Jug B or Jug C
            if(jugA > 0){
                if ((jugA + jugB) <= jugCapacities.get(1)){
                    //Pour all of Jug A into Jug B
                    createChildNode(0, (jugA + jugB), jugC);
                } else{
                    //Pour as much of Jug A as possible into Jug B
                    createChildNode((jugA + jugB - jugCapacities.get(1)), jugCapacities.get(1), jugC);
                }

                if((jugA + jugC) <= jugCapacities.get(2)){
                    //Pour all of Jug A into Jug C
                    createChildNode(0, jugB, (jugA + jugC));
                } else{
                    //Pour as much of Jug A as possible into Jug C
                    createChildNode((jugA + jugC - jugCapacities.get(2)), jugB, jugCapacities.get(2));
                }

                //Empty A
                emptyJug(new Node(0, jugB, jugC));
            }


            //Pour Jug B into Jug A or Jug C
            if (jugB > 0){
                if ((jugB + jugA) <= jugCapacities.get(0)){
                    //Pour all of Jug B into Jug A
                    createChildNode((jugB + jugA), 0, jugC);
                } else{
                    //Pour as much of Jug B as possible into Jug A
                    createChildNode(jugCapacities.get(0), (jugB + jugA - jugCapacities.get(0)), jugC);
                }

                if ((jugB + jugC) <= jugCapacities.get(2)){
                    //Pour all of Jug B into Jug C
                    createChildNode(jugA, 0, (jugB + jugC));
                } else{
                    //Pour as much of Jug B as possible into Jug C
                    createChildNode(jugA, (jugB + jugC - jugCapacities.get(2)), jugCapacities.get(2));
                }

                //Empty B
                emptyJug(new Node(jugA, 0, jugC));
            }


            //Pour Jug C into Jug A or Jug B
            if(jugC > 0){
                if((jugC + jugA) <= jugCapacities.get(0)){
                    //Pour all of Jug C into Jug A
                    createChildNode((jugC + jugA), jugB, 0);
                } else{
                    //Pour as much of Jug C as possible into Jug A
                    createChildNode(jugCapacities.get(0), jugB, (jugC + jugA - jugCapacities.get(0)));
                }

                if((jugC + jugB) <= jugCapacities.get(1)){
                    //Pour all of Jug C into Jug B
                    createChildNode(jugA, (jugC + jugB), 0);
                } else{
                    //Pour as much of Jug C as possible into Jug B
                    createChildNode(jugA, jugCapacities.get(1), (jugC + jugB - jugCapacities.get(1)));
                }

                //Empty Jug C
                emptyJug(new Node(jugA, jugB, 0));
            }

            //Fill Jug A
            if(jugA < jugCapacities.get(0)){
                createChildNode(jugCapacities.get(0), jugB, jugC);
            }

            //Fill Jug B
            if(jugB < jugCapacities.get(1)){
                createChildNode(jugA, jugCapacities.get(1), jugC);
            }

            //Fill Jug C
            if(jugC < jugCapacities.get(2)){
                createChildNode(jugA, jugB, jugCapacities.get(2));
            }
        }
        return nodeCount;
    }


    public static void emptyJug(Node node){
        createChildNode(node.getJugA(), node.getJugB(), node.getJugC());
    }


    public static void createChildNode(int jugA, int jugB, int jugC){
        Node childNode = new Node(jugA, jugB, jugC);
        if(!nodesVisited.contains(childNode.toString())){
            nodeStack.push(childNode);
            nodesVisited.add(childNode.toString());
        }
    }
}
