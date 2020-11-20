import java.util.*;

/**
 * Create by zyk
 * 2020/11/17 10:38
 */
public class asd {
    public void f() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000 ; i++) {
            arrayList.add(random.nextInt(100));
        }

        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while ( !set.contains(arrayList.get(i))) {
            set.add(arrayList.get(i++));
        }
        System.out.println(arrayList.get(i));
    }

//    给定两个字符串 s 和 t，判断它们是否是同构的。
//
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();

        for (int i = 0; i < a1.length; i++) {
            if(!map.containsValue(a2[i])) map.put(a1[i],a2[i]);
        }
        for (int i = 0; i < a1.length; i++) {
            try{
                if (!(map.get(a1[i]) == a2[i])) {
                    return false;
                }
            }catch (NullPointerException E) {
                return false;
            }

        }
        return true;


    }
//    给定两个数组，编写一个函数来计算它们的交集。
    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i : nums1){
            a.add(i);
        }
        for(int i : nums2){
            b.add(i);
        }

        for(int i : a){
            if(b.contains(i) && !result.contains(i)) {
                result.add(i);
            }
        }
        int[] c = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            c[i] = result.get(i);
        }
        return c;

    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return int
     */
    public static int firstUniqChar(String s) {
        ArrayList<Character> arrayList = new ArrayList<>();
        ArrayList<Character> arrayList2 = new ArrayList<>();
        char[] ch = s.toCharArray();
        for (char i : ch) {
            if (arrayList.contains(i)) {
                arrayList2.add(i);
                arrayList.add(i);
            }else {
                arrayList.add(i);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList2.contains(arrayList.get(i))) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            map.put(a, map.getOrDefault(a,0) + 1);
        }
        for(int i = 0; i < n;i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


        public static int singleNumber(int[] nums) {
           int ret = 0;
           for(int i : nums) {
               ret ^= i;
           }
           return ret;
        }
        public static int singleNumber2(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                }else {
                    set.add(nums[i]);
                }
            }

            for (int i : nums) {
                if (set.contains(i)) {
                    return i;
                }
            }
            return -1;
        }

    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * @param J
     * @param S
     * @return int
     */
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        char[] chj = J.toCharArray();
        for(char i : chj) { //石头类型放入set
            set.add(i);
        }
        int count = 0;      //拥有石头个数
        char[] chs =  S.toCharArray();
        for(char i : chs) {     //每当石头中有宝石时候加1
            if (set.contains(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 给定一个链表，每个节点包含一个额外增加的随机指针，
     * 该指针可以指向链表中的任何节点或空节点。
     * 要求返回这个链表的 深拷贝。
     * @param head
     * @return
     */

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {   //浅拷贝，拷贝值，存储关系
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;     //返回head

        while (cur != null) {   //深拷贝，拷贝关系
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphia(String s, String t){
        return isIsomorphi(s, t) && isIsomorphi(t, s);
    }
    public boolean isIsomorphi(String s, String t){
        HashMap<Character, Character> map = new HashMap<>();
        int n = s.length();


        for (int i = 0; i < n; i++) {
            char a1 = s.charAt(i);
            char a2 = t.charAt(i);
            if (map.containsKey(a1)) {
                if (map.get(a1) != a2) {
                    return false;
                }
            }else {
                map.put(a1, a2);
            }
        }
        return true;
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集
     * @param nums1
     * @param nums2
     * @return
     */
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//
//        return Arrays.copyOfRange(intersection, 0, index);
//    }



    /**
     * 从十万个随机数中得到重复的数字
     */

    public static void fun4() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            arrayList.add(num);
        }
        for(int i : arrayList) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

//        for (Integer i : arrayList) {
//            if(map.get(i) > 1) {
//                System.out.println("重复的数字为"+i+"，重复的次数为"+map.get(i));
//            }
//        }


    }

    /**
     * set实现10_0000找重复数字
     */
    public static void fun5() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            arrayList.add(num);
        }

        for (Integer i : arrayList) {
            if (set.contains(i)) {
                System.out.println("重复数字为" + i);
            }else {
                set.add(i);
            }
        }
    }

    /**
     * set与迭代器练习
     */
    public static void fun6() {
        HashSet<String> set = new HashSet<>();
        set.add("asdd");
        set.add("asdd");
        set.add("asd");
        set.add("asd1");
        set.add("asd2");
        set.add("asd3");
        System.out.println(set);

        Iterator<String> it = set.iterator();
            System.out.println(it.next());
        System.out.println(set.size());

        it.remove();
        System.out.println(set.size());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * map练习
     */
    public static void  fun7() {
        HashMap<String, String> map = new HashMap<>();
        map.put("及时雨", "宋江");

        for (Map.Entry<String, String> entry : map.entrySet() ) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


    public static void main(String[] args) {
//        String s = "ab", t = "aa";
//        System.out.println(isIsomorphic(s, t));
//        System.out.println(firstUniqChar("dddccdbba"));
//        int[] a = {2,2,3,4,5,4,5};
//        System.out.println(singleNumber(a));
        fun7();

    }


}

/**
 * 二叉搜索树的删除练习
 */
class BinarySearchTree {
     static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    static Node root = null;

     public static boolean remove (int key) {
         Node cur = root;
         Node parrent = null;

         while (cur != null) {
             if (key > cur.val) {
                 parrent = cur;
                 cur = cur.right;
             }else if(key < cur.val) {
                 parrent = cur;
                 cur = cur.left;
             }else {
                 removeNode(cur, parrent);
                 return true;
             }
         }
         return false;
     }

     public static void removeNode(Node cur, Node parrent) {


        if (cur.left == null) {
            if (cur == root) {
                cur = cur.right;
            }else if (parrent.left == cur) {
                parrent.left = cur.right;
            }else {
                parrent.right = cur.right;
            }
        }else if(cur.right == null) {
            if (cur == root) {
                cur = cur.left;
            }else if (parrent.left == cur) {
                parrent.left = cur.left;
            }else {
                parrent.right = cur.left;
            }
        }else {
            Node targetPar = cur;
            Node target = cur.right;

            while (target.left != null) {
                targetPar = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetPar.left == target) {
                targetPar.left = target.right;
            }else {
                targetPar.right = target.right;
            }
        }


     }

}

