package org.slc.sli.util;

/**
 * This class is for constants that are used in multiple places throughout the application.
 * Constants used only in one class should be kept in that class.
 *
 * @author dwu
 *
 */
public class Constants {
    // API related URLs
    public static final String API_PREFIX = "api/rest";

    public static final String SESSION_CHECK_PREFIX = "api/rest/system/session/check";
    
    public static final String USER_APPS_PREFIX = "api/rest/userapps?is_admin=false";

    public static final String PROGRAM_ELL = "limitedEnglishProficiency";
    public static final String PROGRAM_FRE = "schoolFoodServicesEligibility";

    /*
     * \"name\": \"limitedEnglishProficiency\",
     * \"name\": \"ELL_FORMER\",
     * \"name\": \"504\",
     * \"name\": \"504_FORMER\",
     * \"name\": \"IEP\",
     * \"name\": \"IEP_FORMER\",
     * \"name\": \"LEA\",
     * \"name\": \"RPT\",
     * \"name\": \"RED\",
     * \"name\": \"schoolFoodServiceEligibility\",
     */
    // view config strings - TODO: should these be changed to enums?
    public static final String VIEW_TYPE_STUDENT_LIST = "listOfStudents";
    public static final String VIEW_TYPE_STUDENT_PROFILE_PAGE = "studentProfilePage";
    public static final String FIELD_TYPE_ASSESSMENT = "assessment";
    public static final String FIELD_TYPE_STUDENT_INFO = "studentInfo";
    public static final String FIELD_LOZENGES_POSITION_FRONT = "pre";
    public static final String FIELD_LOZENGES_POSITION_BACK = "post";
    public static final String FIELD_TYPE_HISTORICAL_GRADE = "historicalGrade";
    public static final String FIELD_TYPE_HISTORICAL_COURSE = "historicalCourse";

    // model map keys
    public static final String MM_KEY_LOZENGE_CONFIG = "lozengeConfigs";
    public static final String MM_KEY_VIEW_CONFIG = "viewConfig";
    public static final String MM_KEY_VIEW_CONFIGS = "viewConfigs";
    public static final String MM_KEY_ASSESSMENTS = "assessments";
    public static final String MM_KEY_STUDENTS = "students";
    public static final String MM_KEY_WIDGET_FACTORY = "widgetFactory";
    public static final String MM_KEY_CONSTANTS = "constants";
    public static final String MM_KEY_ATTENDANCE = "attendances";
    public static final String MM_KEY_HISTORICAL = "historicaldata";
    
    // entity attributes
    public static final String ATTR_COURSES = "courses";
    public static final String ATTR_SCHOOL_ID = "schoolId";
    public static final String ATTR_SCHOOLS = "schools";
    public static final String ATTR_SECTIONS = "sections";
    public static final String ATTR_COURSE = "course";
    public static final String ATTR_SECTION_NAME = "sectionName";
    public static final String ATTR_LINK = "link";
    public static final String ATTR_HREF = "href";
    public static final String ATTR_SELF = "self";
    public static final String ATTR_REL = "rel";
    public static final String ATTR_LINKS = "links";
    public static final String ATTR_STUDENT_UIDS = "studentUIDs";
    public static final String ATTR_ID = "id";
    public static final String ATTR_CUSTOM_DATA = "customData";
    public static final String ATTR_ASSESSMENT_NAME = "assessmentName";
    public static final String ATTR_ASSESSMENT_ID = "assessmentId";
    public static final String ATTR_ADMIN_DATE = "administrationDate";
    public static final String ATTR_ASSESSMENT_PERF_LEVEL = "assessmentPerformanceLevel";
    public static final String ATTR_ASSESSMENT_REPORTING_METHOD = "assessmentReportingMethod";
    public static final String ATTR_ASSESSMENT_TITLE = "assessmentTitle";
    public static final String ATTR_ASSESSMENT_FAMILY_HIERARCHY_NAME = "assessmentFamilyHierarchyName";
    public static final String ATTR_RESULT = "result";
    public static final String ATTR_SCORE_RESULTS = "scoreResults";
    public static final String ATTR_MINIMUM_SCORE = "minimumScore";
    public static final String ATTR_MAXIMUM_SCORE = "maximumScore";
    public static final String ATTR_STUDENT_ID = "studentId";
    public static final String ATTR_NAME = "name";
    public static final String ATTR_FIRST_NAME = "firstName";
    public static final String ATTR_LAST_SURNAME = "lastSurname";
    public static final String ATTR_PROGRAMS = "programs";
    public static final String ATTR_YEAR = "year";
    public static final String ATTR_SCALE_SCORE = "Scale score";
    public static final String ATTR_PERF_LEVEL = "Mastery level";
    public static final String ATTR_PERCENTILE = "Percentile";
    public static final String ATTR_LEXILE_SCORE = "Other";
    public static final String ATTR_ED_ORG_ID = "educationOrganizationId";
    public static final String ATTR_ED_ORG_CHILD_ID = "educationOrganizationChildId";
    public static final String ATTR_ED_ORG_PARENT_ID = "educationOrganizationParentId";
    public static final String ATTR_NAME_OF_INST = "nameOfInstitution";
    public static final String ATTR_ASSESSMENT_FAMILY = "assessmentFamily";
    public static final String ATTR_ASSESSMENTS = "assessments";
    public static final String ATTR_COHORT_YEAR = "cohortYear";
    public static final String ATTR_UNIQUE_SECTION_CODE = "uniqueSectionCode";
    public static final String ATTR_STUDENT_ASSESSMENTS = "studentAssessments";
    public static final String ATTR_COURSE_ID = "courseId";
    public static final String ATTR_STUDENT_ATTENDANCES = "attendances";
    public static final String ATTR_PARENT_EDORG = "parentEducationAgencyReference";
    public static final String ATTR_TEACHER_ID = "teacherId";
    public static final String ATTR_SECTION_ID = "sectionId";
    public static final String ATTR_SUBJECTAREA = "subjectArea";
    public static final String ATTR_COURSE_TITLE = "courseTitle";
    public static final String ATTR_SCHOOL_YEAR = "schoolYear";
    public static final String ATTR_SESSION_ID = "sessionId";
    public static final String ATTR_FINAL_LETTER_GRADE = "finalLetterGradeEarned";
    public static final String ATTR_SESSIONS = "sessions";
    public static final String ATTR_CLASSROOM_POSITION = "classroomPosition";
    public static final String ATTR_TERM = "term";
    
    public static final String HISTORICAL_DATA_VIEW = "Historical Data";

    public static final Object ATTR_NAME_WITH_LINK = "name_w_link";
    
    public static final String PARAM_INCLUDE_FIELDS = "includeFields";
    
    //Program Participation Constants
    public static final String SHOW_ELL_LOZENGE = "Yes";

    /**
     * Contains the possible values for FRE participation
     */
    public static enum FREParticipation {
        FREE("Free"), REDUCED_PRICE("Reduced Price");

        private final String value;

        FREParticipation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
