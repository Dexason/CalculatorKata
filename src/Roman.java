class Roman {
    static String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static boolean isRoman(String numb) {
        for (String romanNumber : romanNumbers) {
            if (numb.equals(romanNumber)) {
                return true;
            }
        }
        return false;
    }
}
