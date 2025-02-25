# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE_THIRDPARTY
#   lib/kernel/libclc/ROCM_LICENSE.txt
#   lib/kernel/ocml/LICENSE.TXT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=f1e5cf2520dacf7c8b2461f6084bcc57 \
                    file://LICENSE;md5=f1e5cf2520dacf7c8b2461f6084bcc57 \
                    file://LICENSE_THIRDPARTY;md5=a02029195981d261a0da3a3d30de916e \
                    file://examples/oneapi-samples/src/License.txt;md5=d76e984fe206d5835af9af0f10578e89 \
                    file://lib/CL/devices/level0/npu/include/LICENSE.txt;md5=01026c6f31113af87989fa288d3c3f0a \
                    file://lib/kernel/libclc/ROCM_LICENSE.txt;md5=37d68772710d0d3b5833bbe580e74e3c \
                    file://lib/kernel/ocml/LICENSE.TXT;md5=356efe91bb49e4daf4ce7e734b4b93a2 \
                    file://lib/kernel/sleef/LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/pocl/pocl.git;protocol=https;branch=main"

PV = "1.0+git"
SRCREV = "3b6e5c4b47187d8a954194d673a47e6721e45719"

S = "${WORKDIR}/git"

##  This recipe is not working if built from x64 machine. ##
DEPENDS += "hwloc clang-native spirv-llvm-translator-native"

RDEPENDS:${PN} += "clang-libllvm clang-libclang-cpp clang virtual-opencl-icd spirv-llvm-translator"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DENABLE_ICD=ON -DENABLE_TESTS=OFF -DCMAKE_BUILD_TYPE=Release"

# EXTRA_OECMAKE:append:qemuarm64 = " -DLLC_HOST_CPU=A"
# EXTRA_OECMAKE:append:qemux86-64 = " -DLLC_HOST_CPU=B"
EXTRA_OECMAKE:append:raspberrypi5 = " -DLLC_TRIPLE=aarch64-linux-gnu -DLLC_HOST_CPU=cortex-a76"


# Important envs to set in runtime
# - `POCL_PATH_CLANG`
# - `POCL_PATH_LLVM_SPIRV`