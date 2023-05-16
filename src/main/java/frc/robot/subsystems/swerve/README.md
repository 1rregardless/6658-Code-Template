# For the time being, this directory is a stub with some potential implementations

The SwerveController and SwerveDrive classes are proof-of-concepts for some ideas that I came up with while bored

As such, they should be tested once or twice and only used in production if they are not structurally flawed.

The idea is to provide a slope represented by a tuple (x, y) that represents the direction and power to drive.

It finds the angle we need to set the wheels to using the tan-1 of the slope, and then uses a Hilbert Curve to map the slope onto a single number.

For the Swerve PID controller, it insted maps the robot's current position according to the accelerometer and the desired position into 1d space, then passes that to a PID loop that takes care of actually moving to the point.

We have to map into 1d space to avoid having to do multivariable calculus for the D loop of the 2d controller.