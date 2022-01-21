-- SELECT * FROM Workout WHERE Name = 'This Is Parkour';
-- SELECT * FROM WorkoutGoal WHERE WorkoutId = 12;
-- SELECT * FROM Goal WHERE GoalId IN (3, 8, 15);

SELECT Goal.Name FROM Workout
LEFT JOIN WorkoutGoal ON Workout.WorkoutId = WorkoutGoal.WorkoutId
LEFT JOIN Goal ON WorkoutGoal.GoalId = Goal.GoalId WHERE Workout.Name = 'This Is Parkour';