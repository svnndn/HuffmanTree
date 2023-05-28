import java.util.*;

class HuffmanTree {
    private HuffmanNode root;

    public HuffmanTree() {
        root = null;
    }

    // добавляем элемент
    public void insert(int data, int frequency) {
        long startTime = System.nanoTime();
        HuffmanNode newNode = new HuffmanNode(data, frequency);
        if (root == null) {
            root = newNode;
            return;
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        queue.offer(root);

        int operationCount = 0;
        long totalTime = 0;

        while (!queue.isEmpty()) {
            HuffmanNode node = queue.poll();
            if (node.left == null) {
                node.left = newNode;
                break;
            } else if (node.right == null) {
                node.right = newNode;
                break;
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
            }

            operationCount++;
        }

        System.out.println("Добавлен элемент " + data + ".");
        System.out.println("Количество операций: " + operationCount);

        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        totalTime += elapsedTime;

        System.out.println("Затраченное время: " + elapsedTime + " нс.");
        System.out.println("Общее время: " + totalTime + " нс.");
    }

    // подсчет частоты, т.к. это используется при добавлении
    public int calculateFrequency(int target) {
        return calculateFrequency(root, target);
    }

    private int calculateFrequency(HuffmanNode node, int target) {
        if (node == null) {
            return 0;
        }

        if (node.data == target) {
            return node.frequency;
        }

        int leftFrequency = calculateFrequency(node.left, target);
        int rightFrequency = calculateFrequency(node.right, target);

        return leftFrequency + rightFrequency;
    }
}
