public class ExamQuestion {
    private Exam exam;
    private Question question;

    public ExamQuestion(Question question, Exam exam) {
        this.question = question;
        this.exam = exam;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
