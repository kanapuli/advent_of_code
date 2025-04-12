package solver

// PuzzleSolver is an abstraction of the methods that a solver for a day should satisfy
type PuzzleSolver interface {
	GetName() string
	GetDay() int
	SolvePart01(string) (string, error)
	SolvePart02(string) (string, error)
}
