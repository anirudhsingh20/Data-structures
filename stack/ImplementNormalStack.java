package stack;

public class ImplementNormalStack {
    static class CustomStack {
        int[] data;
        int tos;

        void push(int val) {
            if (tos == data.length - 1) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }
                data = ndata;
            }
            // will run always
            tos++;
            data[tos] = val;
        }

        int peek() {
            return data[tos];
        }

        int pop() {
            if (tos < 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = data[tos];
            tos--;
            return val;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        CustomStack(int size) {
            data = new int[size];
            tos = -1;
        }
    }

    public static void main(String[] args) {
        CustomStack st = new CustomStack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.display();
    }
}
