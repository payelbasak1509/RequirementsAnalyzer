**Objective**

The developed tool provides developers and analysts to reduce manual effort to look for
incomplete and ambiguous requirements in the requirements document. The system analyzes
requirements for completeness and identifies ambiguities.

**Application Use Cases**

The Tool can be used as a high level application for initial requirement review and validation. It
is an excellent tool to identify key defects in requirement in terms of qualities so that they can
be improved upon and then be used in system design.
The typical users of the systems would be:
* System users: Those who will be the actual users of the system can use this application
to analyze whether their requirement specifications are complete and unambiguous so
that designers do not have to come back to them for clarifications.
* Designers: Designers can use the tool to identify issues with the requirement sets so
that they can get them clarified from the users before discussing with developers.
* Document Reviewers: Business managers and major stake holders can use the tool to
review the requirements before approving them for final documentations.


**Implementation**

*The system is an API based open ended pluggable and extendable application.
*It can be easily integrated with standalone User Interfaces for improvements
*The application is platform independent
*It uses open source Apache OpenNLP natural processing models which can be updated
when new updated models are available.
*It can be used with both user stories and formal requirement specification formats.


**Sample Results**

We use the Requirements for Scholar@UC as a test data set and examine the results for the
Repository Manager stakeholder.
The following are the requirements specified for the stakeholder:
* I want to export digital objects and their metadata as an archival information
package at the bit-level. So that I have an exact bit-level copy of the repository
objects.
* I want to have old content in the repository scanned for malware, as virus
definitions are updated. So that I am certain that the content in the repository
doesn't contain any new malware.
* I want to know when a creator for a record or object is no longer affiliated with the
university. So that I am alerted when any logins are no longer associated with
someone at the university.
* I want to create an automatic metadata change for objects/metadata deposited by
someone who no longer has a UC affiliation. So that when users arrive at a object,
they do not send an email to outdated UC contact information.
* I want to have new content in the repository scanned for malware. So that I am
certain that the content in new submissions is malware free.
* I want to be able to create customized workflows for other users of the repository.
So that, not all users have to do the same set of steps -- some may be handled
by me.
* I want to be able to identify broken HTML links in metadata. So that I can decide
whether to remove or redirect broken links.
* I want to get reports about object creation, object page views, content downloads,
and search activity. So that I can see how much the repository is being used.
On running the application we get the following output for the stakeholder:
Analyzing requirements for Repository Manager
=============================================
Analyzing Requirement 1:
Adjective found. Please check for completeness.
I want to export [digital] objects and their metadata as an archival information package at
the [bit-level]. So that I have an [exact] [bit-level] copy of the [repository] objects.
6
Analyzing Requirement 2:
Adjective found. Please check for completeness.
I want to have [old] content in the repository scanned for malware, as virus definitions are
updated. So that I am [certain] that the content in the repository doesn't contain any
[new] malware.
Analyzing Requirement 3:
No inconsistencies detected.
Analyzing Requirement 4:
Adjective found. Please check for completeness.
I want to create an [automatic] metadata change for objects/metadata deposited by
someone who no longer has a UC affiliation. So that when users arrive at a object, they
do not send an email to [outdated] UC contact information.
Analyzing Requirement 5:
Adjective found. Please check for completeness.
I want to Have [new] content in the repository scanned for malware. So that I am
[certain] that the content in [new] submissions is [malware] [free].
Analyzing Requirement 6:
Adjective found. Please check for completeness.
I want to be able to create customized workflows for [other] users of the repository. So
that, not all users have to do the [same] set of steps -- some may be handled by me.
Analyzing Requirement 7:
No inconsistencies detected.
Analyzing Requirement 8:
Adjective found. Please check for completeness.
I want to get reports about object creation, object page views, [content] downloads, and
search activity. So that I can see how [much] the repository is being used.

**Architecture**

*Components*
The application consists of three major components namely, Processor, Analyzer and Helper.
NLPProcessor: Central Processor of the application. Processes requirements from files
NLPAnalyzer: Analyses parsed requirements for quality.
NLPHelper: Provides file reading and console printing support for the application.

