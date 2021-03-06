package hr.fer.zemris.java.hw07.layoutmans;

import java.awt.AWTError;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.io.PrintStream;

import javax.swing.SizeRequirements;

public class StackedLayout implements LayoutManager2 {

	public enum StackedLayoutDirection {
		FILL, FROM_TOP, FROM_BOTTOM
	}
//
//	public static final int X_AXIS = 0;
//    public static final int Y_AXIS = 1;
//    public static final int LINE_AXIS = 2;
//    public static final int PAGE_AXIS = 3;
//
//	public StackedLayout(StackedLayoutDirection fromTop) {
//		// TODO Auto-generated constructor stub
//	}
//
//	public final Container getTarget() {
//        return this.target;
//    }
//
//    public final int getAxis() {
//        return this.axis;
//    }
//
//    public void invalidateLayout(Container target) {
//        checkContainer(target);
//        xChildren = null;
//        yChildren = null;
//        xTotal = null;
//        yTotal = null;
//    }
//
//    public void addLayoutComponent(String name, Component comp) {
//        invalidateLayout(comp.getParent());
//    }
//
//    public void removeLayoutComponent(Component comp) {
//        invalidateLayout(comp.getParent());
//    }
//
//    public void addLayoutComponent(Component comp, Object constraints) {
//        invalidateLayout(comp.getParent());
//    }
//
//    public Dimension preferredLayoutSize(Container target) {
//        Dimension size;
//        synchronized(this) {
//            checkContainer(target);
//            checkRequests();
//            size = new Dimension(xTotal.preferred, yTotal.preferred);
//        }
//
//        Insets insets = target.getInsets();
//        size.width = (int) Math.min((long) size.width + (long) insets.left + (long) insets.right, Integer.MAX_VALUE);
//        size.height = (int) Math.min((long) size.height + (long) insets.top + (long) insets.bottom, Integer.MAX_VALUE);
//        return size;
//    }
//
//    public Dimension minimumLayoutSize(Container target) {
//        Dimension size;
//        synchronized(this) {
//            checkContainer(target);
//            checkRequests();
//            size = new Dimension(xTotal.minimum, yTotal.minimum);
//        }
//
//        Insets insets = target.getInsets();
//        size.width = (int) Math.min((long) size.width + (long) insets.left + (long) insets.right, Integer.MAX_VALUE);
//        size.height = (int) Math.min((long) size.height + (long) insets.top + (long) insets.bottom, Integer.MAX_VALUE);
//        return size;
//    }
//
//    public Dimension maximumLayoutSize(Container target) {
//        Dimension size;
//        synchronized(this) {
//            checkContainer(target);
//            checkRequests();
//            size = new Dimension(xTotal.maximum, yTotal.maximum);
//        }
//
//        Insets insets = target.getInsets();
//        size.width = (int) Math.min((long) size.width + (long) insets.left + (long) insets.right, Integer.MAX_VALUE);
//        size.height = (int) Math.min((long) size.height + (long) insets.top + (long) insets.bottom, Integer.MAX_VALUE);
//        return size;
//    }
//
//    public float getLayoutAlignmentX(Container target) {
//        checkContainer(target);
//        checkRequests();
//        return xTotal.alignment;
//    }
//
//    public float getLayoutAlignmentY(Container target) {
//        checkContainer(target);
//        checkRequests();
//        return yTotal.alignment;
//    }
//
//    public void layoutContainer(Container target) {
//        checkContainer(target);
//        int nChildren = target.getComponentCount();
//        int[] xOffsets = new int[nChildren];
//        int[] xSpans = new int[nChildren];
//        int[] yOffsets = new int[nChildren];
//        int[] ySpans = new int[nChildren];
//
//        Dimension alloc = target.getSize();
//        Insets in = target.getInsets();
//        alloc.width -= in.left + in.right;
//        alloc.height -= in.top + in.bottom;
//
//        // Resolve axis to an absolute value (either X_AXIS or Y_AXIS)
//        ComponentOrientation o = target.getComponentOrientation();
//        int absoluteAxis = resolveAxis( axis, o );
//        boolean ltr = (absoluteAxis != axis) ? o.isLeftToRight() : true;
//
//
//        // determine the child placements
//		checkRequests();
//
//		if (absoluteAxis == X_AXIS) {
//			SizeRequirements.calculateTiledPositions(alloc.width, xTotal,
//					xChildren, xOffsets, xSpans, ltr);
//			SizeRequirements.calculateAlignedPositions(alloc.height, yTotal,
//					yChildren, yOffsets, ySpans);
//		} else {
//			SizeRequirements.calculateAlignedPositions(alloc.width, xTotal,
//					xChildren, xOffsets, xSpans, ltr);
//			SizeRequirements.calculateTiledPositions(alloc.height, yTotal,
//					yChildren, yOffsets, ySpans);
//		}
//
//        // flush changes to the container
//        for (int i = 0; i < nChildren; i++) {
//            Component c = target.getComponent(i);
//            c.setBounds((int) Math.min((long) in.left + (long) xOffsets[i], Integer.MAX_VALUE),
//                        (int) Math.min((long) in.top + (long) yOffsets[i], Integer.MAX_VALUE),
//                        xSpans[i], ySpans[i]);
//
//        }
//        if (dbg != null) {
//            for (int i = 0; i < nChildren; i++) {
//                Component c = target.getComponent(i);
//                dbg.println(c.toString());
//                dbg.println("X: " + xChildren[i]);
//                dbg.println("Y: " + yChildren[i]);
//            }
//        }
//
//    }
//
//    void checkContainer(Container target) {
//        if (this.target != target) {
//            throw new AWTError("BoxLayout can't be shared");
//        }
//    }
//
//    void checkRequests() {
//        if (xChildren == null || yChildren == null) {
//            // The requests have been invalidated... recalculate
//            // the request information.
//            int n = target.getComponentCount();
//            xChildren = new SizeRequirements[n];
//            yChildren = new SizeRequirements[n];
//            for (int i = 0; i < n; i++) {
//                Component c = target.getComponent(i);
//                if (!c.isVisible()) {
//                    xChildren[i] = new SizeRequirements(0,0,0, c.getAlignmentX());
//                    yChildren[i] = new SizeRequirements(0,0,0, c.getAlignmentY());
//                    continue;
//                }
//                Dimension min = c.getMinimumSize();
//                Dimension typ = c.getPreferredSize();
//                Dimension max = c.getMaximumSize();
//                xChildren[i] = new SizeRequirements(min.width, typ.width,
//                                                    max.width,
//                                                    c.getAlignmentX());
//                yChildren[i] = new SizeRequirements(min.height, typ.height,
//                                                    max.height,
//                                                    c.getAlignmentY());
//            }
//
//            // Resolve axis to an absolute value (either X_AXIS or Y_AXIS)
//            int absoluteAxis = resolveAxis(axis,target.getComponentOrientation());
//
//            if (absoluteAxis == X_AXIS) {
//                xTotal = SizeRequirements.getTiledSizeRequirements(xChildren);
//                yTotal = SizeRequirements.getAlignedSizeRequirements(yChildren);
//            } else {
//                xTotal = SizeRequirements.getAlignedSizeRequirements(xChildren);
//                yTotal = SizeRequirements.getTiledSizeRequirements(yChildren);
//            }
//        }
//    }
//
//    private int resolveAxis( int axis, ComponentOrientation o ) {
//        int absoluteAxis;
//        if( axis == LINE_AXIS ) {
//            absoluteAxis = o.isHorizontal() ? X_AXIS : Y_AXIS;
//        } else if( axis == PAGE_AXIS ) {
//            absoluteAxis = o.isHorizontal() ? Y_AXIS : X_AXIS;
//        } else {
//            absoluteAxis = axis;
//        }
//        return absoluteAxis;
//   }
//
//
//    private int axis;
//    private Container target;
//
//    private transient SizeRequirements[] xChildren;
//    private transient SizeRequirements[] yChildren;
//    private transient SizeRequirements xTotal;
//    private transient SizeRequirements yTotal;
//
//    private transient PrintStream dbg;

	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layoutContainer(Container arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension minimumLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLayoutComponent(Component arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLayoutComponent(Component arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getLayoutAlignmentX(Container arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getLayoutAlignmentY(Container arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void invalidateLayout(Container arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension maximumLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
