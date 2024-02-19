
public class MovementThread implements Runnable {

	private final Movement movement;
	public boolean isLinked;

	public MovementThread(Movement movement, boolean isLinked) {
		this.movement = movement;
		this.isLinked = isLinked;
	}

	@Override
	public void run() {
		Movement.MovementType type = movement.MOVEMENT_TYPE;
		String timestamp = "[" + Double.toString((double) (System.currentTimeMillis() - Main.START_TIME) / 1000)
				+ "s] ";
		if (!isLinked)
			System.out.print(timestamp);

		// DRIVE CASES
		if (type.isDriveType) {
			System.out.print(">>> " + "Drive " + movement.INCHES_STRAFE * type.SGN_strafe + "in x "
					+ movement.INCHES_FORWARD * type.SGN_forward + "in ");
			if (movement.ignoreStartVelocity && movement.ignoreEndVelocity)
				System.out.print(" (ignoring START and END velocity)");
			else if (movement.ignoreStartVelocity)
				System.out.print(" (ignoring START velocity)");
			else if (movement.ignoreEndVelocity)
				System.out.print(" (ignoring END velocity)");
		}

		// TURN CASES
		if (type.isTurnType) {
			System.out.print(">>> " + "Turn " + movement.DEGREES_TURN * type.SGN_turn + "° ");
		}

		// ARM CASES
		if (type.isArmType) {
			System.out.print(">>> " + "Raise Arm " + movement.DEGREES_ELEVATION * type.SGN_elevation + "° ");
		}

		// DELAY CASE
		if (type == Movement.MovementType.DELAY) {
			System.out.print(">>> " + "Sleep " + movement.WAIT + "ms ");
			try {
				Thread.sleep(movement.WAIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// CLAW CASES
		if (type.isClawType) {
			if (type == Movement.MovementType.OPEN_LEFT_CLAW)
				System.out.print(">>> " + "Open Left Claw ");
			if (type == Movement.MovementType.OPEN_RIGHT_CLAW)
				System.out.print(">>> " + "Open Right Claw ");
			if (type == Movement.MovementType.CLOSE_RIGHT_CLAW)
				System.out.print(">>> " + "Close Right Claw ");
			if (type == Movement.MovementType.CLOSE_LEFT_CLAW)
				System.out.print(">>> " + "Close Left Claw ");
		}

		// ELBOW CASES
		if (type == Movement.MovementType.REST_ELBOW) {
			System.out.print(">>> " + "Rest Elbow ");
		}
		if (type == Movement.MovementType.FLIP_ELBOW) {
			System.out.print(">>> " + "Flip Elbow ");
		}

		// WRIST CASES
		if (type == Movement.MovementType.SET_WRIST) {
			System.out.print(">>> " + "Set Wrist " + movement.SERVO_POSITION + " ");
		}

		// CV CASES
		if (type.isCVType) {
			if (type == Movement.MovementType.WHITE_PXL_ALIGN)
				System.out.print(">>> " + "WHITE_PXL_ALIGN ");
			if (type == Movement.MovementType.APRIL_TAG_ALIGN)
				System.out.print(">>> " + "APRIL_PXL_ALIGN ");
		}

		if (!isLinked)
			System.out.println();

	}

}
