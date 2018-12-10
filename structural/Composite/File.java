interface FileInterface {
    public void defaultMethod(int depth);
    public List<FileInterface> getChildren();
    public boolean addComponent(FileInterface c);
    public boolean removeComponent(FileInterface c);
 }
 
 
 class File implements FileInterface {
 
    private String name;
 
    public File(String name) {
        this.name = name;
    }
 
    public void defaultMethod(int depth) {
        for (int i = 0; i < depth; i++) System.out.print("  ");
        System.out.println("file:" + this.name);
    }
 
    public List<FileInterface> getChildren() { return null; }
    public boolean addComponent(FileInterface c) { return false; }
    public boolean removeComponent(FileInterface c) { return false; }
 
 }
  
 
 class Folder implements FileInterface {
    private String name;
    private List<FileInterface> fileList = new ArrayList<FileInterface>();
    public Folder(String name) { this.name = name; }
 
    public void defaultMethod(int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("  ");
        System.out.println("folder:" + name);
        for (FileInterface file : fileList) {
            file.defaultMethod(depth + 1);
        }
    }
 
    public List<FileInterface> getChildren() { return this.fileList; }
    public boolean addComponent(FileInterface c) { return this.fileList.add(c); }
    public boolean removeComponent(FileInterface c) { return this.fileList.remove(c); }
 }
 
 
 public class DirectoryUser {
    public static void main(String [] args){
        FileInterface root = new Folder("root");
        FileInterface usr = new Folder("usr");
        FileInterface var = new Folder("var");
        FileInterface home = new Folder("home");
        FileInterface user1 = new Folder("user1");
        FileInterface file1 = new File("file1");
 
        root.addComponent(usr);
        usr.addComponent(var);
        root.addComponent(home); 
        home.addComponent(user1);
        user1.addComponent(file1);
        root.defaultMethod(0);
 
    }
 }