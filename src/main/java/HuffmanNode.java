class HuffmanNode {
    int data;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = null;
        right = null;
    }
}