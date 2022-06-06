package utiles;

import java.awt.Color;
import java.awt.Component;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ImgTabla extends DefaultTableCellRenderer{

	DefaultTableCellRenderer cellRederer = new DefaultTableCellRenderer();
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		cellRederer.setHorizontalAlignment(SwingConstants.CENTER);
		if(value instanceof JLabel) {
			JLabel lbl = (JLabel) value;
			return lbl;
		}
		for (int i = 0; i < table.getColumnCount()-1; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellRederer);
		}
		table.getSelectionModel().setSelectionInterval(0, 0);
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
