import java.util.Base64;

public class Codec {

    private static final String HASH_KEY = ":UNIQUE-DELIM:";
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        
        for(int i = 0; i < strs.size(); i++)
        {
            String item = strs.get(i); 
                        
            if(i == strs.size() -1)
            {
                sb.append(item);
            }else
            {
                sb.append(item);
                sb.append(HASH_KEY); 
            }
        }
        
        return Base64.getEncoder().encodeToString(sb.toString().getBytes()); 
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        byte[] unpack = Base64.getDecoder().decode(s);
        
        String rawData = new String(unpack); 
        
        String[] arr = rawData.split(HASH_KEY, -1); 
        
        List<String> list = new ArrayList(); 
        
        for(String entry : arr)
        {
            list.add(entry);
        }
        
        return list; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));