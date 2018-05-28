SUMMARY = "Basic testing image: firmware"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    python-grpcio-tools \
    python-daemon \
    python-pybluez \
    udevil \
"
