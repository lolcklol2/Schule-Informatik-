#version 330

in vec2 frgTextCoords; //TODO Change name
in vec4 frgColor;

uniform sampler2D txtSampler;

out vec4 outColor;

void main() {
    outColor = frgColor * texture(txtSampler, frgTextCoords);
}