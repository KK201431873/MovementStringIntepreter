// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {

	public static String s = """

			                 .forwardLeft(21, 11)
			                 .openRightClaw()
			                 .sleepFor(150)
			                 .backward(10)
			                 .left(7)
			                 .turnRight(90)
			                 .raiseArm(10, true)
			                 .flipElbow()
			                 .left(10)
			                 .raiseArm(200, true)
			                 .backward(12)
			                 .openLeftClaw()
			                 .sleepFor(333)
			                 .forward(5)
			                 .restElbow()
			                 .left(31)
			                 .lowerArm(200, true)
			                 .forwardLeft(81, 5, false, true)
			                 .forward(10)
			                 .lowerArm(10, true)
			                 .closeBothClaws()
			                 .sleepFor(500)
			                 .backward(10, false, true)
			                 .raiseArm(10, true)
			                 .backwardRight(81, 5)
			                 .flipElbow()
			                 .right(22)
			                 .raiseArm(190, true)
			                 .sleepFor(250)
			                 .backward(8)
			                 .openBothClaws()
			                 .sleepFor(1000)
			                 .forward(5)
			                 .restElbow()
			                 .left(20)
			                 .lowerArm(190, true)
			                 .backward(15)
			                 .forward(5)
			                 .lowerArm(10, true)
				.forward(10, false, true)
				.forwardRight(10, 5, false, true)
				.raiseArm(90, true)
				.forward(10)
			""";

	public static String s_arr = """
									            // START POSE (-40.75,63.5,-90)

			{
			}
			{
			.forwardLeft(37.5, 2.75)
			.turnRight(90)
			                    .openRightClaw()
			                    .sleepFor(150)
			.backward(4)
			.backwardRight(1, 10)
			.forwardRight(28, 1)
			                    .raiseArm(10, true)
			                    .closeRightClaw()
			                    .sleepFor(150)
			.backwardRight(32, 23)
			.backward(41)
			                    .raiseArm(10, true)
			.backwardLeft(33, 30)
			                    .flipElbow()
			                    .raiseArm(200, true)
			.backward(3)
			                    .openBothClaws()
			                    .sleepFor(150)
			.forward(3)
			.forwardRight(33, 30)
			                    .restElbow()
			                    .closeLeftClaw()
			                    .lowerArm(210, true)
			.forward(41)
			.forwardLeft(32, 23)
			                    .lowerArm(10, true)
			                    .closeRightClaw()
			                    .sleepFor(500)
			.backwardRight(32, 23)
			.backward(41)
			                    .raiseArm(10, true)
			.backwardLeft(33, 18)
			                    .flipElbow()
			                    .raiseArm(220, true)
			.backward(3)
			                    .openRightClaw()
			                    .sleepFor(150)
			.forward(7)
			.left(29)
			                    .restElbow()
			                    .lowerArm(220, true)
			                    .openLeftClaw()
			}
			{
			}
			{
			}
									            """;
	public static String seqns = "// cv_seq { .forwardLeft(4, 8) // calibrate } // purple_seq { .closeBothClaws() .right(8) //calibrate - should be equal to amount moved left by cv .forward(24) //calibrate .turnLeft(90) .forward(5) //calibrate .openRightClaw() // release purple pixel .sleepFor(500) .backward(5) } // yellow_seq { .left(24) //should be equal to initial forward .forward(92) //calibrate .raiseArm(35) .right(20) //calibrate .openLeftClaw() .sleepFor(500) } // park_seq { .backward(5) .turnRight(180) .right(20) .backward(9) .lowerArm(25) .lowerArm(10) .forward(2, true) }";

	public static String pavementJogger = """
			.forward(47).turnLeft(90).forward(48).forwardLeft(36,23).backwardRight(12,10).backwardRight(3,4).backwardRight(7,16).backwardRight(4,17).backwardRight(5,8).backwardRight(17,7).backward(10).backwardLeft(6,2).backwardLeft(10,1).backwardLeft(18,4).backwardLeft(11,13).backwardLeft(7,14).forwardLeft(3,24).forwardLeft(8,5).forwardLeft(11,7).forwardLeft(9,4).forwardLeft(11,2).forwardLeft(15,1).forwardRight(9,4).forwardRight(8,5).forwardRight(11,3).forwardRight(11,2).forwardRight(10,10).forwardRight(3,17).forwardRight(5,20).forwardRight(2,8).backward(2).backwardRight(14,1).backward(11).forwardRight(25,33).backwardRight(11,9).backwardLeft(10,6).backwardLeft(4,11).forwardLeft(11,15).left(15).backwardLeft(9,19).backwardLeft(10,6).backwardLeft(13,7).forwardLeft(4,7).forwardRight(3,2).forwardRight(5,2).forwardRight(4,3).forwardRight(3,6).forwardRight(6,10).forwardRight(5,10).forwardRight(5,16).forwardRight(2,9).backwardRight(3,14).backwardRight(9,12).backwardRight(10,4).backwardLeft(8,6).backwardLeft(7,1).backward(11).backward(8).backward(4).backward(6).backwardRight(8,2).backward(7).backwardLeft(4,1).backwardLeft(5,6).backwardLeft(1,3).forwardLeft(1,17).forwardLeft(2,8).left(7).forwardLeft(1,2).forwardLeft(3,2).left(8).backwardLeft(1,4).left(8).backwardLeft(1,11).forwardLeft(1,9).left(3).forwardLeft(3,11).forwardLeft(4,11).forwardLeft(2,4).forward(4).forwardLeft(4,1).forwardLeft(6,1).forwardLeft(9,1).forward(6).forwardLeft(6,1).forwardRight(8,1).forwardRight(8,1).forward(5).forwardRight(4,2).right(5).forwardRight(2,8).right(14).forwardRight(1,16).forwardRight(1,16).backwardRight(1,15).backwardRight(1,6).right(2).forward(1).backwardRight(1,19).backwardRight(2,5).backwardRight(1,7).backwardRight(6,9).backwardRight(11,3).backwardLeft(3,1).backwardLeft(9,2).backwardLeft(5,2).backwardLeft(7,2).backward(2).backward(6).backwardLeft(6,1).backward(5).backwardLeft(5,1).backwardLeft(6,2).backwardLeft(11,7).backwardLeft(4,10).backwardLeft(2,16).backwardLeft(1,12).forwardLeft(4,20).left(9).forwardLeft(1,14).left(18).backwardLeft(1,6).left(1).left(1).turnRight(50).forwardLeft(2.6944072722000003,1.6553457195999997).forwardLeft(6.427876097,7.660444431).forwardLeft(0.5195307763000001,2.1748764959).forwardLeft(6.3046192636,9.0692764838).forwardLeft(3.7334688248,6.0050987114).forwardLeft(3.0906812151,5.239054268299999).forwardLeft(1.9283628291000001,2.2981333292999997).forwardLeft(3.0906812151,5.239054268299999).forwardLeft(7.0706637067,8.4264888741).forwardLeft(4.3762564345,6.7711431545).forwardLeft(3.8567256582000002,4.596266658599999).forwardLeft(5.2655577110000005,4.7195234919999995).forwardLeft(4.8692837681,1.1358149432999998).forwardRight(10.8743824795,2.5976538815000003).forwardRight(7.5371875976,5.0190440442).forwardRight(8.4264888741,7.0706637067).forwardRight(13.5157828663,16.562717576100003).forwardRight(3.0376743296999997,10.381355145899999).backwardRight(3.4869551580000007,8.822762817000001).backwardRight(5.0190440442,7.5371875976).backwardRight(5.2655577110000005,4.7195234919999995).backwardRight(2.4478936054,4.4730098252).backwardRight(6.9474068733,9.8353209269).backwardRight(6.674389763800001,4.8427803254).backwardRight(8.3297354834,2.1483730531999994).backwardRight(7.044160264,0.6162841669999999).backwardRight(7.3171773735,5.6088247685).backwardRight(6.9209034306,2.0251162197999992)
			""";

	public static long START_TIME;

	public static void main(String[] args) {
		START_TIME = System.currentTimeMillis();
		DriveSubsystem drive = new DriveSubsystem();

		MovementSequence seq = new MovementSequenceBuilder().append(s).build();

//		drive.followMovementSequence(seq, "testing ignoreVelocity");

		MovementSequence[] seqs = MovementStringInterpreter.toMovementSequenceArray(s_arr);

//		drive.followMovementSequence(seq, "example sequence");
//		for (int i = 0; i < seqs.length; i++)
//			drive.followMovementSequence(seqs[i], "Auto Close Blue Step " + (i + 1));

//		MovementSequence cursed = new MovementSequenceBuilder().append(pavementJogger).build();
//
//		drive.followMovementSequence(cursed, "AAHHHH");

		MovementSequence test = new MovementSequenceBuilder()
				.forward(10, false, true)
				.forwardRight(10, 5, false, true)
				.raiseArm(90, true)
				.forward(10)
				.build();

//		drive.followMovementSequence(test, "TEST");
		
		MovementSequence main = new MovementSequenceBuilder()
                .backward(5, false, true)
                .backwardLeft(5, 5, false, true)
                .backward(5)
                .lowerArm(10, true)
                .backward(5)
                .build();
		
		drive.followMovementSequence(main, "BLUE 2+2");

	}

}
