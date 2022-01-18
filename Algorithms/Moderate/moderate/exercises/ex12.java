package moderate.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML Encoding Since XML is very verbose, you are given a way of encoding it
 * where each tag gets mapped to a pre-defined integer value. Write code to
 * print the encoded version of an XML element
 * 
 * APPROACH:
 * This is actually pretty simple, and we can tackle from a tree strategy. Just to 
 * pay attention in how we define Element and Attribute objects.
 * 
 * #Trees
 * 
 * @author luisa
 */
public class ex12 {

	enum Tag {
		family, person, firstName, lastName, state
	}

	/**
	 * Represents a XML element.
	 * 
	 */
	public static class Element {

		private List<Attribute> attributes;
		private String value;
		private List<Element> children;

		public Element() {
			this.attributes = new ArrayList<>();
			this.children = new ArrayList<>();
			this.value = null;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}

		public void addAttribute(Attribute attribute) {
			this.attributes.add(attribute);
		}

		public void addChildren(Element elem) {
			this.children.add(elem);
		}

		public List<Attribute> getAttributes() {
			return this.attributes;
		}

		public List<Element> getChildren() {
			return this.children;
		}

	}

	/**
	 * Represents an attribute
	 */
	public static class Attribute {
		private Tag tag;
		private String value;

		public Attribute(Tag tag, String value) {
			this.tag = tag;
			this.value = value;
		}

		public Tag getTag() {
			return this.tag;
		}

		public String getValue() {
			return this.value;
		}
	}

	public static StringBuilder encodingXML(Element root, StringBuilder strResult) {
		Map<Tag, Integer> mapping = new HashMap<Tag, Integer>();
		mapping = Map.of(Tag.family, 1, Tag.person, 2, Tag.firstName, 3, Tag.lastName, 4, Tag.state, 5);

		if (root == null)
			return strResult;

		// Store the attributes first
		for (Attribute attribute : root.getAttributes()) {
			strResult.append(mapping.get(attribute.getTag()) + " ");
			if (attribute.getValue() != null)
				strResult.append(attribute.getValue() + " ");
		}
		// At the end, 0 to close it
		strResult.append("0 ");
		// In case this element has a value, print it.
		if(root.getAttributes() != null)
			strResult.append(root.getValue() + " ");

		// Explore the rest of the children
		for (Element children : root.getChildren())
			encodingXML(children, strResult);

		strResult.append("0 ");
		
		
		return strResult;
	}

	public static void main(String[] args) {
		// Init XML
		Element elemPerson = new Element();
		elemPerson.addAttribute(new Attribute(Tag.person, null));
		elemPerson.addAttribute(new Attribute(Tag.firstName, "Gayle"));
		elemPerson.setValue("Some Message");

		Element elemFamily = new Element();
		elemFamily.addAttribute(new Attribute(Tag.family, null));
		elemFamily.addAttribute(new Attribute(Tag.lastName, "McDowell"));
		elemFamily.addAttribute(new Attribute(Tag.state, "CA"));
		elemFamily.addChildren(elemPerson);

		// Decode
		StringBuilder res = new StringBuilder();
		StringBuilder sol = encodingXML(elemFamily, res);

		System.out.println(sol);

	}

}
