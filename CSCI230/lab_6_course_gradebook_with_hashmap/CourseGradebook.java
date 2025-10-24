package lab_6_course_gradebook_with_hashmap;

import java.util.*;

public class CourseGradebook extends Gradebook {
	// Declare any protected fields here (change placeholder field below)
	class GradebookKey {
		public String assignmentString;
		public Integer studentId;

		public GradebookKey(String assignmentString, Integer studentId) {
			this.assignmentString = assignmentString;
			this.studentId = studentId;
		}

		@Override
		public boolean equals(Object other) {
			if (getClass() != other.getClass()) {
				return false;
			}
			GradebookKey otherKey = (GradebookKey) other;
			if (this == otherKey || (this.studentId.equals(otherKey.studentId)
					&& this.assignmentString.equals(otherKey.assignmentString))) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(assignmentString, studentId);
		}
	}

	private HashMap<GradebookKey, Double> gradeData;

	public CourseGradebook() {
		this.gradeData = new HashMap<GradebookKey, Double>();
	}

	@Override
	public void setScore(String assignmentName, Integer studentID, Double score) {
		GradebookKey newItem = new GradebookKey(assignmentName, studentID);
		gradeData.put(newItem, score);
	}

	@Override
	public double getScore(String assignmentName, Integer studentID) {
		Double value = gradeData.get(new GradebookKey(assignmentName, studentID));
		return value == null ? Double.NaN : value;
	}

	@Override
	public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
		HashMap<Integer, Double> results = new HashMap<Integer, Double>();
		Set<GradebookKey> keys = gradeData.keySet();
		for (GradebookKey key : keys) {
			if (key.assignmentString == assignmentName) {
				results.put(key.studentId, gradeData.get(key));
			}
		}
		return results;
	}


	@Override
	public ArrayList<String> getSortedAssignmentNames() {
		Set<String> assignments = new HashSet<String>();
		Set<GradebookKey> keys = gradeData.keySet();
		for (GradebookKey key : keys) {
			assignments.add(key.assignmentString);
		}

		ArrayList<String> data = new ArrayList<String>(assignments);
		data.sort((a, b) -> a.compareTo(b));
		return data;
	}

	@Override
	public ArrayList<Integer> getSortedStudentIDs() {
		Set<Integer> assignments = new HashSet<Integer>();
		Set<GradebookKey> keys = gradeData.keySet();
		for (GradebookKey key : keys) {
			assignments.add(key.studentId);
		}
		ArrayList<Integer> data = new ArrayList<Integer>(assignments);
		data.sort((a, b) -> a.compareTo(b));
		return data;
	}

	@Override
	public HashMap<String, Double> getStudentScores(Integer studentID) {
		HashMap<String, Double> assignmentGrades = new HashMap<>();
		Set<GradebookKey> keys = gradeData.keySet();
		for (GradebookKey key : keys) {
			if (key.studentId.equals(studentID)) {
				assignmentGrades.put(key.assignmentString, gradeData.get(key));
			}
		}
		return assignmentGrades;
	}


}
