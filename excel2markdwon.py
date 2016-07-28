def excel2md(excelFile):
    import xlrd
    data = xlrd.open_workbook(excelFile)
    for sheet in data.sheet_names():
        print("export sheet "+sheet)
        exportMdFromSheet(data.sheet_by_name(sheet))

def exportMdFromSheet(sheet):
    mdFile = open(sheet.name+".md", "w")
    for i in range(sheet.nrows):
        row = sheet.row(i)    
        mdFile.write(getOneLine(row))
        if i == 0:
            mdFile.write(getSecondLine(len(row)))
    mdFile.close()

def getOneLine(row):
    line = "|"
    for cell in row:
        val = cell.value
        if isinstance(val, unicode):
            val = val.encode("utf-8")
	else:
	    val = str(val).encode("utf-8")
        if cell.ctype == 1 and "\n" in val:
            line = line + " ".join(val.splitlines()) + "|"
        else:
            line = line + str(val) + "|"
    return line + "\n"

def getSecondLine(colCount):
    return "|-----" * colCount + "|" + "\n"


if __name__ == "__main__":
    import sys
    reload(sys)
    sys.setdefaultencoding( "utf-8" )
    if len(sys.argv) > 1:
            print("export excel file "+ sys.argv[1]+ "'s content to markdown files")
            excel2md(sys.argv[1])
