# XML Editor built with Java & Scene Builder for GUI
## Background
The XML editor to process xml files, users can load an XML file and choose one of multiple features from buttons in GUI. Once a file is uploaded, the program shows its contents. The user can then, choose one of the supported features.


## Supported Features (for milestone 1):
- Consistency check
- Format/Prettify
- Minify
- XML to JSON
- Compression/decompression


## Consistency check
Check if the XML file is consistent, that is, all opening tags have corresponding closing tags.
This check is done using Stack data structure.
If the XML file is inconsistent, number of errors, and tags left in the stack are displayed to the user.


## Format/Prettify
Adjust the indentation of an XML file, to make it more readable.
If the file is not consistent, user cannot format it.

## Minify
Since spaces and newlines (\n) are actually characters that can increase the size of an XML document. This feature should aim at decreasing the size of an XML file by deleting the whitespaces and indentations.


## XML to JSON
JSON((Javascript Object Notation) is a format that is used to represent data, and it's widely used to share structures information over the web.
Conversion to XML is done on three iterations:
1. Transform the xml string into array of node objects.
2. transforms this array into a tree of nodes.
3. transforms the tree recursively into JSON string

## Compression/Decompression
Compression using Huffman-Coding.
This type of compression is done using heap (min priority queue) and tree data structure.
By using variable character sizes we can compress the input file efficiently.
