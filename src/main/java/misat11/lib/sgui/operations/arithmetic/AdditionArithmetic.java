package misat11.lib.sgui.operations.arithmetic;

import org.bukkit.entity.Player;

import misat11.lib.sgui.SimpleGuiFormat;

public class AdditionArithmetic extends AbstractArithmetic {

	public AdditionArithmetic(SimpleGuiFormat format, Object obj1, Object obj2) {
		super(format, obj1, obj2);
	}

	@Override
	public Object resolveFor(Player player, Object obj1, Object obj2) {
		if (obj1 instanceof Number && obj2 instanceof Number) {
			return ((Number) obj1).doubleValue() + ((Number) obj2).doubleValue();
		}
		return obj1.toString() + obj2.toString();
	}

}