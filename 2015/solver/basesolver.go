package solver

type BaseSolver struct {
	name string
	day  int
}

// GetName returns the name of the solver.
func (b BaseSolver) GetName() string {
	return b.name
}

// GetDay returns the day of the solver.
func (b BaseSolver) GetDay() int {
	return b.day
}
