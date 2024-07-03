class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("^\\.|\\.+$", "");
        new_id = new_id.isEmpty() ? "a" : new_id;
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15).replaceAll("\\.+$", "") : new_id;
        while(new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length()-1);
        }
        return new_id;
    }
}