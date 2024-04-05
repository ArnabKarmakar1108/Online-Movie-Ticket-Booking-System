

	<!--header ends here-->

	<!--content starts here-->
	<div class="home-content-wrapper">
		<div class="overlay-box">
			<div class="container fancy-text">
				<div class="t3xts t3xt-1">Online</div>
				<div class="t3xts t3xt-2">Ticket Booking</div>
				<div class="t3xts t3xt-3">System</div>
				<!-- <div class="welcome-text text-center fancy-text">Online Ticket Booking System</div>	 -->
			</div>
		</div>	
	</div>

	<style>
		.fancy-text {
			font-family: "Roboto Mono";
			font-size: 100px;
			color: black;
			text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
			-webkit-background-clip: text;
			padding: 20px 100px; /* Adjust padding horizontally and vertically */
			line-height: 1; /* Increase line-height to prevent overlapping */
		}
		.t3xts {
			line-height: 1;
			position: relative;
			perspective: 2000px;
			text-transform: uppercase;
			padding-top: 100px;
			}

			.t3xt {
			transform-style: preserve-3d;
			position: absolute;
			top: 0;
			text-transform: uppercase;
			padding-top: 100px;
			}

			.t3xt-out {
			animation: text-out 0.5s ease;
			}

			.t3xt-in {
			animation: text-in 0.5s ease;
			}

			@keyframes text-out {
			to {
				transform: rotateX(90deg);
				opacity: 0;
			}
			}
			@keyframes text-in {
			from {
				opacity: 0;
				transform: rotateX(-90deg);
			}
			to {
				transform: rotateX(0deg);
				opacity: 1;
			}
			}
			.ref {
			background-color: red;
			border-radius: 3px;
			padding: 20px 60px;
			position: absolute;
			font-size: 16px;
			bottom: 10px;
			right: 10px;
			color: #fff;
			font-weight: 300;
			font-family: sans-serif;
			text-decoration: none;
			}
			.ref::first-letter {
			font-size: 200px;
			}
	</style>

	<script>
		
		function n3xt(text, element) {
		let sample = document.querySelector(element);
		if (sample.dataset.animating === 'true') return;
		let sampleH = 50; // will keep it fixed, otherwise sample.offsetHeight
		let sampleT = sample.textContent; // old text
		let sampleNT = text; // new text
		sample.dataset.animating = 'true';
		sample.style.height = sampleH + 'px';

		// original text element
		let samO = document.createElement('div');
		samO.style.transformOrigin = '0 ' + sampleH / 2 + 'px -' + sampleH / 2 + 'px';
		samO.classList.add('t3xt');
		samO.textContent = sampleT;

		// new text element
		let samN = samO.cloneNode();
		samN.textContent = sampleNT;
		sample.textContent = '';
		sample.appendChild(samO);
		sample.appendChild(samN);

		samO.classList.add('t3xt-out');
		samN.classList.add('t3xt-in');

		samN.addEventListener('animationend', function (event) {
			sample.removeChild(samO);
			sample.removeChild(samN);
			sample.textContent = sampleNT;
			sample.dataset.animating = 'false';
		});
		}


		let phraseIndex = 1;
		let wordIndex = 0;
		let t3xts = [
		["Online", "Ticket Booking", "System"],
		];


		// start it off
		setTimeout(changetext, 200);

		function changetext() {
		if (wordIndex > 2) {
			wordIndex = 0;
			phraseIndex++;
		}
		if (phraseIndex >= t3xts.length) {
			phraseIndex = 0;
		}
		let term = t3xts[phraseIndex][wordIndex];
		n3xt(term, '.t3xt-' + ++wordIndex);

		if (wordIndex == 3) {
			setTimeout(changetext, 2000);
		} else {
			setTimeout(changetext, 150);
		}
		}
	</script>
	<!--content ends here-->