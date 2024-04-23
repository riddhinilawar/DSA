// "static void main" must be defined in a public class.
/*
Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file’s name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don’t exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn’t exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Note:

You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
You can assume that all directory names and file names only contain lower-case letters, and same names won’t exist in the same directory.
*/
public class Main {
    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        System.out.println(obj.ls("/"));
        obj.mkdir("/a/b/c");
        obj.addContentToFile("/a/b/c/d","hello");
        System.out.println(obj.ls("/"));
        System.out.println(obj.readContentFromFile("/a/b/c/d"));
    }
}

//won't work for file and folder with same name in same directory, because hashmap stores 1 reference
class FileSystem {
    class File {
        boolean isFile = false;
        HashMap<String, File> files = new HashMap<>();
        String content = "";
    }
    File root;
    public FileSystem() {
        root = new File();
    }
    public List<String> ls(String path) {
        File curr = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            //first position after split will be empty
            String[] directories = path.split("/");
            for (int i = 1; i < directories.length; i++) {
                curr = curr.files.get(directories[i]);
            }
            if (curr.isFile) {
                files.add(directories[directories.length - 1]);
                return files;
            }
        }
        List<String> res_files = new ArrayList<>(curr.files.keySet());
        Collections.sort(res_files);
        return res_files;
    }
    public void mkdir(String path) {
        File curr = root;
        String[] directories = path.split("/");
        for (int i = 1; i < directories.length; i++) {
            if (!curr.files.containsKey(directories[i])) {
                curr.files.put(directories[i], new File());
            }
            curr = curr.files.get(directories[i]);
        }
    }
    public void addContentToFile(String filePath, String content) {
        File curr = root;
        String[] directories = filePath.split("/");
        //go till the last folder
        for (int i = 1; i < directories.length - 1; i++) {
            curr = curr.files.get(directories[i]);
        }
        //check if file exists
        if (!curr.files.containsKey(directories[directories.length - 1])) {
            curr.files.put(directories[directories.length - 1], new File());
        }
        curr = curr.files.get(directories[directories.length - 1]);
        curr.isFile = true;
        curr.content = curr.content + content;
    }
    public String readContentFromFile(String filePath) {
        File curr = root;
        String[] directories = filePath.split("/");
        for (int i = 1; i < directories.length - 1; i++) {
            curr = curr.files.get(directories[i]);
        }
        return curr.files.get(directories[directories.length - 1]).content;
    }
}
