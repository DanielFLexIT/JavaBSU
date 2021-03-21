import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLReader {
    private DefaultListModel<Student> student = new DefaultListModel<>();
    public DefaultListModel<Student> ReadData(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(file, handler);
        return student;
    }
    private class XMLHandler extends DefaultHandler{
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("student")){
                int id = Integer.parseInt(attributes.getValue("id"));
                String surname = attributes.getValue("name");
                int course = Integer.parseInt(attributes.getValue("course"));
                int group = Integer.parseInt(attributes.getValue("group"));
                student.addElement(new Student(id, surname, course, group));
            }
        }
    }
}
