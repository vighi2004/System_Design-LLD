//making Document editor which follows SOLID principles like Goggle Docs, Microsoft Word, etc.

import java.util.ArrayList;
import java.util.List;

interface DocumentElement{
    String render();
}
 class TextElement implements DocumentElement{
     private String text;
     public TextElement(String text) {
         this.text = text;
     }

     @Override
     public String render() {
         return text;
     }
}

class ImageElement implements DocumentElement{
    private String Imagepath;
    public ImageElement(String imagepath) {
        Imagepath = imagepath;
    }
    @Override
    public String render() {
        return "Image: [" + Imagepath + "]";
    }
}

class FontStyle implements DocumentElement{
    private String text;
    private String style;
    public FontStyle(String text, String style) {
        this.text = text;
        this.style = style;
    }
    @Override
    public String render() {
        return "Text: [" + text + "] with Style: [" + style + "]";
    }
}
 class Document{
    private List<DocumentElement> Docs= new ArrayList<>();
    public void addElement(DocumentElement doc){
         Docs.add(doc);
    }

    public String render(){
        String result = " ";
        for(DocumentElement doc: Docs){
            result += doc.render() + "\n";
        }
        return result;
    }
}

interface persistence{
       void save(String text);
}
class SaveToFile implements persistence{
    @Override
    public void save(String text){
        System.out.println("Document saved to file: " + text);
    }
}

class SaveToDB implements persistence{
    @Override
    public void save(String text){
        System.out.println("Document saved to database: " + text);
    }
}

class DocumentEditor{
    private Document doc;
    private persistence saveMethod;
    String renderedDoc;
    public DocumentEditor(Document doc, persistence saveMethod) {
        this.doc = doc;
        this.saveMethod = saveMethod;
    }
    public void addElement(String text){
        doc.addElement(new TextElement(text));
    }
    public void addImage(String imagePath){
        doc.addElement(new ImageElement(imagePath));
    }
    public void addStyledText(String text, String style){
        doc.addElement(new FontStyle(text, style));
    }
    public void saveDocument(){
        saveMethod.save(doc.render());
    }
    public String renderedDoc(){
            if(renderedDoc==null){
               renderedDoc=doc.render();
            }
            return renderedDoc;
    }
}
public class DocEditor {
    public static void main(String[] args) {
        Document doc=new Document();
        persistence saveMethod=new SaveToDB();
        DocumentEditor editor=new DocumentEditor(doc, saveMethod);
        editor.addElement("Hello World");
        editor.addImage("path/to/image.jpg");
        editor.addStyledText("This is bold text", "italic");
        System.out.println(editor.renderedDoc());
    }
}
