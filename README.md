-- Corrected employee table
CREATE TABLE `employee` (
  `employee_id` int NOT NULL,
  `employee_name` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `in_time` TIME DEFAULT NULL,
  `out_time` TIME DEFAULT NULL,
  `toggle_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
);

-- Corrected attendance table
CREATE TABLE `attendance` (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `in_time` TIME DEFAULT NULL,
  `out_time` TIME DEFAULT NULL,
  `toggle_state` varchar(10) DEFAULT NULL,
  `date` DATE DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  FOREIGN KEY (`employee_id`) REFERENCES `employee`(`employee_id`)
);

-- Corrected employeedata table
CREATE TABLE `employeedata` (
  `employeeId` int NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
);
