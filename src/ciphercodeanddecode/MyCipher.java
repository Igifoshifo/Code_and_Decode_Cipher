package ciphercodeanddecode;


public class MyCipher 
{
    private int key;
    private String password;
    
    MyCipher()
    {
        key = 0;
        password = "";
    }
    
    public void setKey(int k)
    {
        key = k;
    }
    
    public String encodeString(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i)==' ') 
            {
                password += 'e';
            }
            //122 = 'z'
            else if(((char)(s.charAt(i)+key)) >= 122)
            {
                password += (char) (s.charAt(i)+key)-27;
            }  
            else 
            {
                password += (char) (s.charAt(i)+key);
            }
        }
        
        return password;
    }
}