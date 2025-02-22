# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "BSD-2-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a10c5f7fe245e681d23c8bd9fdd4f580 \
                    file://include/hipSYCL/common/msgpack/LICENSE;md5=dc8d9338196901e4b996293320ca5b08 \
                    file://include/hipSYCL/sycl/libkernel/detail/fp16/LICENSE;md5=998fb0b16ad8a4fb8bd41bf3faf2d21c"

SRC_URI = "gitsm://github.com/AdaptiveCpp/AdaptiveCpp.git;protocol=https;branch=develop"

# Modify these as desired
PV = "1.0+git"
SRCREV = "v24.10.0"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: CUDA HIP LLVM OpenCL Filesystem
# NOTE: the following library dependencies are unknown, ignoring: LLVM- Y LLVM hiprtc
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "boost-native clang-native"

RDEPENDS:${PN} += "clang-libllvm clang-libclang-cpp"

FILES:${PN} += "${libdir}/hipSYCL/librt-backend-omp.so \
    ${libdir}/hipSYCL/bitcode/libkernel-sscp-*.bc \
    ${libdir}/hipSYCL/llvm-to-backend/libllvm-to-host.so \
    ${libdir}/hipSYCL/llvm-to-backend/libllvm-to-backend.so \
    ${libdir}/hipSYCL/llvm-to-backend/llvm-to-host-tool \
    ${sysconfdir}/AdaptiveCpp/acpp-core.json \
    ${prefix}/etc/AdaptiveCpp/acpp-core.json"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

INSANE_SKIP:${PN} = "buildpaths dev-deps"
INSANE_SKIP:${PN}-dbg = "buildpaths"
INSANE_SKIP:${PN}-dev = "dev-elf"
