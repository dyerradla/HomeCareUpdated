package com.homecare.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * EmployeeInfo generated by hbm2java
 */
@Entity
@Table(name = "employee_info", catalog = "homecare")
public class EmployeeInfo implements java.io.Serializable {

	private Long employeeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date createDt;
	private String createUserId;
	private String designation;
	private Character application;
	private Character resume;
	private Character referenceChecks;
	private Character signedJobDescription;
	private Character orientationChecklist;
	private Character statementOfConfidentiality;
	private Character policy;
	private Date initialCompetencyEvaluation;
	private Date ongoinCompetencyEvaluation;
	private Date annualEvaluation;
	private Character hippaTraining;
	private Character oshaTraining;
	private Date cprCard;
	private Date profLicense;
	private Character verificationProfLicense;
	private Character socialSecurityCard;
	private Character nonCompete;
	private Date driversLicense;
	private Date proofValidCarInsurance;
	private Character authorizationCriminalCheck;
	private Character criminalCheck;
	private Character fingerprintsResults;
	private Character federalW4;
	private Character michiganW4;
	private Character i9;
	private Date tbTest;
	private Character hvbTest;
	private String emailAddress;
	private String phoneNumber;
	private Set<EmployeeInfoAudit> employeeInfoAudits = new HashSet<EmployeeInfoAudit>(0);
	private List<String> employeeReminderMessage;
	public EmployeeInfo() {
	}

	public EmployeeInfo(Long employeeId, String firstName, String lastName,
			Date createDt, String createUserId,
			Date initialCompetencyEvaluation, Date ongoinCompetencyEvaluation,
			Date annualEvaluation, Date cprCard, Date profLicense,
			Date driversLicense, Date proofValidCarInsurance, Date tbTest) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createDt = createDt;
		this.createUserId = createUserId;
		this.initialCompetencyEvaluation = initialCompetencyEvaluation;
		this.ongoinCompetencyEvaluation = ongoinCompetencyEvaluation;
		this.annualEvaluation = annualEvaluation;
		this.cprCard = cprCard;
		this.profLicense = profLicense;
		this.driversLicense = driversLicense;
		this.proofValidCarInsurance = proofValidCarInsurance;
		this.tbTest = tbTest;
	}

	public EmployeeInfo(Long employeeId, String firstName, String middleName,
			String lastName, Date createDt, String createUserId,
			String designation, Character application, Character resume,
			Character referenceChecks, Character signedJobDescription,
			Character orientationChecklist,
			Character statementOfConfidentiality, Character policy,
			Date initialCompetencyEvaluation, Date ongoinCompetencyEvaluation,
			Date annualEvaluation, Character hippaTraining,
			Character oshaTraining, Date cprCard, Date profLicense,
			Character verificationProfLicense, Character socialSecurityCard,
			Character nonCompete, Date driversLicense,
			Date proofValidCarInsurance, Character authorizationCriminalCheck,
			Character criminalCheck, Character fingerprintsResults,
			Character federalW4, Character michiganW4, Character i9,
			Date tbTest, Character hvbTest, String emailAddress,
			String phoneNumber, Set employeeInfoAudits,List<String> employeeReminderMessage) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.createDt = createDt;
		this.createUserId = createUserId;
		this.designation = designation;
		this.application = application;
		this.resume = resume;
		this.referenceChecks = referenceChecks;
		this.signedJobDescription = signedJobDescription;
		this.orientationChecklist = orientationChecklist;
		this.statementOfConfidentiality = statementOfConfidentiality;
		this.policy = policy;
		this.initialCompetencyEvaluation = initialCompetencyEvaluation;
		this.ongoinCompetencyEvaluation = ongoinCompetencyEvaluation;
		this.annualEvaluation = annualEvaluation;
		this.hippaTraining = hippaTraining;
		this.oshaTraining = oshaTraining;
		this.cprCard = cprCard;
		this.profLicense = profLicense;
		this.verificationProfLicense = verificationProfLicense;
		this.socialSecurityCard = socialSecurityCard;
		this.nonCompete = nonCompete;
		this.driversLicense = driversLicense;
		this.proofValidCarInsurance = proofValidCarInsurance;
		this.authorizationCriminalCheck = authorizationCriminalCheck;
		this.criminalCheck = criminalCheck;
		this.fingerprintsResults = fingerprintsResults;
		this.federalW4 = federalW4;
		this.michiganW4 = michiganW4;
		this.i9 = i9;
		this.tbTest = tbTest;
		this.hvbTest = hvbTest;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.employeeInfoAudits = employeeInfoAudits;
		this.employeeReminderMessage = employeeReminderMessage;
	}

	@Id
	@Column(name = "EMPLOYEE_ID", unique = true)
	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "FIRST_NAME", nullable = false, length = 32)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MIDDLE_NAME", length = 1)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LAST_NAME", nullable = false, length = 32)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DT", length = 19)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_USER_ID", nullable = false, length = 20)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "DESIGNATION", length = 10)
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "APPLICATION", length = 1)
	public Character getApplication() {
		return this.application;
	}

	public void setApplication(Character application) {
		this.application = application;
	}

	@Column(name = "RESUME", length = 1)
	public Character getResume() {
		return this.resume;
	}

	public void setResume(Character resume) {
		this.resume = resume;
	}

	@Column(name = "REFERENCE_CHECKS", length = 1)
	public Character getReferenceChecks() {
		return this.referenceChecks;
	}

	public void setReferenceChecks(Character referenceChecks) {
		this.referenceChecks = referenceChecks;
	}

	@Column(name = "SIGNED_JOB_DESCRIPTION", length = 1)
	public Character getSignedJobDescription() {
		return this.signedJobDescription;
	}

	public void setSignedJobDescription(Character signedJobDescription) {
		this.signedJobDescription = signedJobDescription;
	}

	@Column(name = "ORIENTATION_CHECKLIST", length = 1)
	public Character getOrientationChecklist() {
		return this.orientationChecklist;
	}

	public void setOrientationChecklist(Character orientationChecklist) {
		this.orientationChecklist = orientationChecklist;
	}

	@Column(name = "STATEMENT_OF_CONFIDENTIALITY", length = 1)
	public Character getStatementOfConfidentiality() {
		return this.statementOfConfidentiality;
	}

	public void setStatementOfConfidentiality(
			Character statementOfConfidentiality) {
		this.statementOfConfidentiality = statementOfConfidentiality;
	}

	@Column(name = "POLICY", length = 1)
	public Character getPolicy() {
		return this.policy;
	}

	public void setPolicy(Character policy) {
		this.policy = policy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INITIAL_COMPETENCY_EVALUATION", length = 19)
	public Date getInitialCompetencyEvaluation() {
		return this.initialCompetencyEvaluation;
	}

	public void setInitialCompetencyEvaluation(Date initialCompetencyEvaluation) {
		this.initialCompetencyEvaluation = initialCompetencyEvaluation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ONGOIN_COMPETENCY_EVALUATION", length = 19)
	public Date getOngoinCompetencyEvaluation() {
		return this.ongoinCompetencyEvaluation;
	}

	public void setOngoinCompetencyEvaluation(Date ongoinCompetencyEvaluation) {
		this.ongoinCompetencyEvaluation = ongoinCompetencyEvaluation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ANNUAL_EVALUATION", length = 19)
	public Date getAnnualEvaluation() {
		return this.annualEvaluation;
	}

	public void setAnnualEvaluation(Date annualEvaluation) {
		this.annualEvaluation = annualEvaluation;
	}

	@Column(name = "HIPPA_TRAINING", length = 1)
	public Character getHippaTraining() {
		return this.hippaTraining;
	}

	public void setHippaTraining(Character hippaTraining) {
		this.hippaTraining = hippaTraining;
	}

	@Column(name = "OSHA_TRAINING", length = 1)
	public Character getOshaTraining() {
		return this.oshaTraining;
	}

	public void setOshaTraining(Character oshaTraining) {
		this.oshaTraining = oshaTraining;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CPR_CARD", length = 19)
	public Date getCprCard() {
		return this.cprCard;
	}

	public void setCprCard(Date cprCard) {
		this.cprCard = cprCard;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROF_LICENSE", length = 19)
	public Date getProfLicense() {
		return this.profLicense;
	}

	public void setProfLicense(Date profLicense) {
		this.profLicense = profLicense;
	}

	@Column(name = "VERIFICATION_PROF_LICENSE", length = 1)
	public Character getVerificationProfLicense() {
		return this.verificationProfLicense;
	}

	public void setVerificationProfLicense(Character verificationProfLicense) {
		this.verificationProfLicense = verificationProfLicense;
	}

	@Column(name = "SOCIAL_SECURITY_CARD", length = 1)
	public Character getSocialSecurityCard() {
		return this.socialSecurityCard;
	}

	public void setSocialSecurityCard(Character socialSecurityCard) {
		this.socialSecurityCard = socialSecurityCard;
	}

	@Column(name = "NON_COMPETE", length = 1)
	public Character getNonCompete() {
		return this.nonCompete;
	}

	public void setNonCompete(Character nonCompete) {
		this.nonCompete = nonCompete;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DRIVERS_LICENSE", length = 19)
	public Date getDriversLicense() {
		return this.driversLicense;
	}

	public void setDriversLicense(Date driversLicense) {
		this.driversLicense = driversLicense;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROOF_VALID_CAR_INSURANCE", length = 19)
	public Date getProofValidCarInsurance() {
		return this.proofValidCarInsurance;
	}

	public void setProofValidCarInsurance(Date proofValidCarInsurance) {
		this.proofValidCarInsurance = proofValidCarInsurance;
	}

	@Column(name = "AUTHORIZATION_CRIMINAL_CHECK", length = 1)
	public Character getAuthorizationCriminalCheck() {
		return this.authorizationCriminalCheck;
	}

	public void setAuthorizationCriminalCheck(
			Character authorizationCriminalCheck) {
		this.authorizationCriminalCheck = authorizationCriminalCheck;
	}

	@Column(name = "CRIMINAL_CHECK", length = 1)
	public Character getCriminalCheck() {
		return this.criminalCheck;
	}

	public void setCriminalCheck(Character criminalCheck) {
		this.criminalCheck = criminalCheck;
	}

	@Column(name = "FINGERPRINTS_RESULTS", length = 1)
	public Character getFingerprintsResults() {
		return this.fingerprintsResults;
	}

	public void setFingerprintsResults(Character fingerprintsResults) {
		this.fingerprintsResults = fingerprintsResults;
	}

	@Column(name = "FEDERAL_W4", length = 1)
	public Character getFederalW4() {
		return this.federalW4;
	}

	public void setFederalW4(Character federalW4) {
		this.federalW4 = federalW4;
	}

	@Column(name = "MICHIGAN_W4", length = 1)
	public Character getMichiganW4() {
		return this.michiganW4;
	}

	public void setMichiganW4(Character michiganW4) {
		this.michiganW4 = michiganW4;
	}

	@Column(name = "I9", length = 1)
	public Character getI9() {
		return this.i9;
	}

	public void setI9(Character i9) {
		this.i9 = i9;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TB_TEST", length = 19)
	public Date getTbTest() {
		return this.tbTest;
	}

	public void setTbTest(Date tbTest) {
		this.tbTest = tbTest;
	}

	@Column(name = "HVB_TEST", length = 1)
	public Character getHvbTest() {
		return this.hvbTest;
	}

	public void setHvbTest(Character hvbTest) {
		this.hvbTest = hvbTest;
	}

	@Column(name = "EMAIL_ADDRESS", length = 50)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "PHONE_NUMBER", length = 10)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeInfo")
	public Set<EmployeeInfoAudit> getEmployeeInfoAudits() {
		return this.employeeInfoAudits;
	}

	public void setEmployeeInfoAudits(Set<EmployeeInfoAudit> employeeInfoAudits) {
		this.employeeInfoAudits = employeeInfoAudits;
	}

	@Transient
	public List<String> getEmployeeReminderMessage() {
		return employeeReminderMessage;
	}

	public void setEmployeeReminderMessage(List<String> employeeReminderMessage) {
		this.employeeReminderMessage = employeeReminderMessage;
	}
}
