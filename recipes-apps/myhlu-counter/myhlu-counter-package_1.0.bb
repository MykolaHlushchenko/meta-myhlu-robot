SUMMARY = "My Custom ROS 2 Counter Package"
DESCRIPTION = "ROS 2 nodes for counting, fetched from custom GitHub repository via SSH"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# GitHub Repository
SRC_URI = "git://github.com/MykolaHlushchenko/Ros2-WS;protocol=https;branch=main"
SRCREV = "${AUTOREV}"

# Path to CMakeLists.txt and package.xml in repository
S = "${WORKDIR}/git/src/myhlu_counter_package"

# Inherit ROS 2 packages ament_cmake

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_distro_humble
inherit ros_component
inherit ros_ament_cmake

# Add dependensies
DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
    ros-environment \   
    rclcpp \
    std-msgs \
    std-srvs \
"

# Add dependensies (runtime)
RDEPENDS:${PN} = " \
    rosidl-default-runtime \
    rclcpp \
    std-msgs \
    std-srvs \
"

FILES:${PN} += " \
    ${opt_dir}/ros/${ROS_DISTRO}/* \
"

