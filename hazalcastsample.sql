CREATE DATABASE IF NOT EXISTS `hazelcastsample`;

USE `hazelcastsample`;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) DEFAULT NULL,
  `name` text,
  `role` text
);

INSERT INTO `employee` (`id`, `name`, `role`) VALUES
	(1, 'Bhawani Singh', 'SPL');
