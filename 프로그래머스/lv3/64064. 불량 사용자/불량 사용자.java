import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        HashSet<HashSet<String>> set = new HashSet<>();
        dfs(user_id, banned_id, 0, new HashSet<>(), set);
        return set.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int index, HashSet<String> selectedUsers, HashSet<HashSet<String>> set) {
        if (index == banned_id.length) {
            if (selectedUsers.size() == banned_id.length) {
                set.add(new HashSet<>(selectedUsers));
            }
            return;
        }
        
        for (String user : user_id) {
            if (selectedUsers.contains(user)) {
                continue;
            }
            
            if (isMatch(user, banned_id[index])) {
                selectedUsers.add(user);
                dfs(user_id, banned_id, index + 1, selectedUsers, set);
                selectedUsers.remove(user);
            }
        }
    }
    
    private boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
