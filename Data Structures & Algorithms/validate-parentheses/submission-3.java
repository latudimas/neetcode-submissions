class Solution {
    public boolean isValid(String s) {
        // butuh mapping untuk (), {} dan []. 
        // val   key
        // )    (
        // }    {
        // ]    [

        // array penampung char[] penampung
        // if selama charAt(s) == "(" || "{" || "["
        //     insert ke array
        // else :
        //     check last element at array. 
        //     get the val from last element as the key 
        //     if current charAt(s) == value from mapping -> remove/delete element from the array
        //     else : return false
        // if array is empty ? true: false
        
        List<Character> list = new ArrayList<>();


        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('(', ')');
        mapping.put('{', '}');
        mapping.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                list.add(s.charAt(i));

            } else {
                if (list.size() == 0) {
                    return false;
                }
                char lastElm = list.getLast();
                char expectedClosing = mapping.get(lastElm);
                if (s.charAt(i) == expectedClosing) {
                    list.remove(list.size() - 1);

                } else {
                    return false;
                }
            }
        }
        return list.size() == 0 ? true : false;
    }
}
